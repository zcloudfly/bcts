package com.bcts.service.sso.controller;

import com.bcts.common.domain.BctsSysUser;
import com.bcts.common.utils.CookieUtils;
import com.bcts.common.utils.MapperUtils;
import com.bcts.service.sso.consumer.RedisService;
import com.bcts.service.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;

/**
 * @author yunfei
 * @description LoginController
 * @Date 2020/4/9 0009
 */
@Controller
public class LoginController {
    @Autowired
    private LoginService loginService;
    @Autowired
    private RedisService redisService;

    /**
     *
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(HttpServletRequest request,Model model,@RequestParam(required = false) String url) {
        String token = CookieUtils.getCookieValue(request, "token");
        if(!StringUtils.isEmpty(token)){
            String  loginCode= redisService.get(token);
            if(!StringUtils.isEmpty(loginCode)){
                String json = redisService.get(loginCode);
                if(!StringUtils.isEmpty(json)){
                    try {
                        BctsSysUser bctsSysUser = MapperUtils.json2pojo(json, BctsSysUser.class);
                        model.addAttribute("user",bctsSysUser);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }
        return "login";

    }

    /**
     *
     * @param loginCode
     * @param password
     * @param url  从哪里来的请求
     * @param req
     * @param res
     * @return
     */
    @RequestMapping(value = "login",method = RequestMethod.POST)
    public String login(String loginCode, String password, RedirectAttributes attributes,
                        @RequestParam(required = false) String url,//非必需参数
                        HttpServletRequest req, HttpServletResponse res){
        BctsSysUser bctsSysUser = loginService.login(loginCode, password);
        //登陆失败
        if(bctsSysUser==null){
            attributes.addFlashAttribute("message","用户名或密码错误");
        }
        //登陆成功
        else{
            //把token 和 loginCode 对应上  存在cookie  解决安全问题
            String token = UUID.randomUUID().toString();
            String ok = redisService.put(token, loginCode, 60 * 60 * 24);
            if(!StringUtils.isEmpty(ok) && ok.equals("ok")) {
                CookieUtils.setCookie(req, res, "token", token,60 * 60 * 24);
                if(!StringUtils.isEmpty(url)) {
                    return "redirect:" + url;
                }
                attributes.addFlashAttribute("message","登录成功");
            }else{
                attributes.addFlashAttribute("message","服务器异常，稍后再试");
            }
        }

        return "redirect:/login";
    }
}
