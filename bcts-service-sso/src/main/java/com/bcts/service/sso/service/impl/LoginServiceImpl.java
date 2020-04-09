package com.bcts.service.sso.service.impl;

import com.bcts.common.domain.BctsSysUser;
import com.bcts.common.utils.MapperUtils;
import com.bcts.service.sso.consumer.RedisService;
import com.bcts.service.sso.mapper.BctsSysUserMapper;
import com.bcts.service.sso.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

/**
 * @author yunfei
 * @description LoginServiceImpl
 * @Date 2020/4/9 0009
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private RedisService redisService;
    @Autowired
    private BctsSysUserMapper bctsSysUserMapper;
    @Override
    public BctsSysUser login(String loginCode, String plantPassword)  {
        BctsSysUser bctsSysUser=null;
        String json = redisService.get(loginCode);
        try {
            //redis里user null   则查询数据库
            if(StringUtils.isEmpty(json)){
                Example example = new Example(BctsSysUser.class);
                example.createCriteria().andEqualTo("loginCode", loginCode);
                bctsSysUser = bctsSysUserMapper.selectOneByExample(example);
                if (bctsSysUser != null) {
                    String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
                    if (password.equals(bctsSysUser.getPassword())) {
                        redisService.put(loginCode,MapperUtils.obj2json(bctsSysUser),60*60*24);
                        return  bctsSysUser;
                    }
                }
            }else{
                //有数据 则返回
                bctsSysUser = MapperUtils.json2pojo(json, BctsSysUser.class);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return bctsSysUser;
    }
}
