package com.bcts.service.admin.service.impl;

import com.bcts.common.domain.BctsSysUser ;
import com.bcts.service.admin.mapper.BctsSysUserMapper;
import com.bcts.service.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import tk.mybatis.mapper.entity.Example;
@Service
@Transactional(readOnly = true)
public class AdminServiceImpl implements AdminService {
    @Autowired
    private  BctsSysUserMapper bctsSysUserMapper;
    @Override
    @Transactional(readOnly = false)
    public void register(BctsSysUser bctsSysUser) {
        int i=bctsSysUserMapper.insert(bctsSysUser);
        System.out.println(i+"=====================================");
    }

    @Override
    public BctsSysUser login(String loginCode, String plantPassword) {
        Example example = new Example(BctsSysUser.class);
        example.createCriteria().andEqualTo("loginCode", loginCode);

        BctsSysUser bctsSysUser = bctsSysUserMapper.selectOneByExample(example);
        if (bctsSysUser != null) {
            String password = DigestUtils.md5DigestAsHex(plantPassword.getBytes());
            if (password.equals(bctsSysUser.getPassword())) {
                return bctsSysUser;
            }
        }
        return null;
    }

}
