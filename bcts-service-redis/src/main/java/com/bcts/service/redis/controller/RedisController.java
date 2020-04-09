package com.bcts.service.redis.controller;

import com.bcts.service.redis.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RedisController {

    @Autowired
    private RedisService redisService;

    @RequestMapping(value = "put",method = RequestMethod.POST)
    public String put(String key,String value,long seconds){
        try {
            redisService.set(key, value, seconds);
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
        return "ok";
    }
    @RequestMapping(value = "get",method = RequestMethod.GET)
    public String get(String key){
        Object o = redisService.get(key);
       if(o!=null) {
           return String.valueOf(o);
       }
       return null;
    }
}
