package com.bcts.web.admin.service;

import com.bcts.web.admin.service.fallback.AdminServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "bcts-service-admin",fallback = AdminServiceFallback.class)
public interface AdminService {

    @RequestMapping(value = "login",method = RequestMethod.GET)
    public String login(@RequestParam(value = "logincode") String logincode,@RequestParam(value = "password") String password);
}
