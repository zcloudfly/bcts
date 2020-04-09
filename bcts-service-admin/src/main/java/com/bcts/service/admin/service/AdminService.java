package com.bcts.service.admin.service;

import com.bcts.common.domain.BctsSysUser ;

public interface AdminService {

    /**
     * 注册
     * @param bctsSysUser
     */
    public void register(BctsSysUser bctsSysUser);

    /**
     * 登录
     * @param loginCode  账号
     * @param plantPassword 明文密码
     * @return
     */
    public BctsSysUser login(String loginCode,String plantPassword);
}
