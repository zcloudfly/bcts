package com.bcts.service.sso.service;

import com.bcts.common.domain.BctsSysUser;

/**
 * 登录
 * @author yunfei
 * @description LoginService
 * @Date 2020/4/9 0009
 */
public interface LoginService {

    /**
     * 登录
     * @param loginCode
     * @param plantPassword
     * @return
     */
    public BctsSysUser login(String loginCode,String plantPassword);
}
