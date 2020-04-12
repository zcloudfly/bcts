package com.bcts.service.admin.controller;

import com.bcts.common.dto.BaseResult;
import com.bcts.common.domain.BctsSysUser ;
import com.bcts.service.admin.service.AdminService;
import com.google.common.collect.Lists;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Admincontroller {

    @Autowired
    private AdminService adminService;

    /**
     * 登陆
     * @param loginCode
     * @param password
     * @return
     */
    @ApiOperation(value = "登录接口")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(name = "loginCode", value = "登录账号", required = true, dataType = "String"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "String"),
            // @ApiImplicitParam(name = "tbSysUserJson", value = "管理员对象 JSON 字符串", required = false, dataTypeClass = String.class, paramType = "json")
    })
    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public BaseResult login(String loginCode,String password) {
        BaseResult baseResult = checkLogin(loginCode, password);
        if(baseResult!=null){
            return baseResult;
        }
        BctsSysUser bctsSysUser = adminService.login(loginCode, password);
        //登陆成功
        if (bctsSysUser != null) {
           return BaseResult.ok(bctsSysUser);
            //登陆失败
        } else {
            return BaseResult.notok(Lists.newArrayList(new BaseResult.Error("","登陆失败")));
        }
    }

     private BaseResult checkLogin(String loginCode,String password){
        BaseResult baseResult=null;
         if(StringUtils.isEmpty(loginCode)||StringUtils.isEmpty(password)){
             baseResult=BaseResult.notok(Lists.newArrayList(
                     new BaseResult.Error("loginCode&password","登录名或密码不能为空")
             ));
         }
         return baseResult;
     }



}
