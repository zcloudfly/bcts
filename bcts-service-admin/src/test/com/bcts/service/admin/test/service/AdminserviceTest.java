package com.bcts.service.admin.test.service;

import com.bcts.common.domain.BctsSysUser;
import com.bcts.service.admin.ServiceAdminApplication;

import com.bcts.service.admin.service.AdminService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ServiceAdminApplication.class)
@ActiveProfiles(value = "dev")
//@Transactional
//@Rollback
public class AdminserviceTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void register(){
        BctsSysUser bctsSysUser = new BctsSysUser();
        bctsSysUser.setUserCode(UUID.randomUUID().toString());
        bctsSysUser.setLoginCode("920869693@qq.com");
        bctsSysUser.setUserName("zhangyunfei");
        bctsSysUser.setUserType("1");
        bctsSysUser.setMgrType("1");
        bctsSysUser.setStatus("0");
        bctsSysUser.setCreateBy(bctsSysUser.getUserCode());
        bctsSysUser.setCreateDate(new Date());
        bctsSysUser.setUpdateBy(bctsSysUser.getUserCode());
        bctsSysUser.setUpdateDate(new Date());
        bctsSysUser.setCorpCode("0");
        bctsSysUser.setCorpName("bcts");
        bctsSysUser.setPassword(DigestUtils.md5DigestAsHex("123456".getBytes()));
        adminService.register(bctsSysUser);
    }

    @Test
    public void login(){
        BctsSysUser tbSysUser = adminService.login("920869693@qq.com", "123456");
        System.out.println(tbSysUser);
        Assert.assertNotNull(tbSysUser);
    }
}
