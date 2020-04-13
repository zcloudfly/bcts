package com.rabbitmq.controller;

import com.rabbitmq.provider.RabbitProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yunfei
 * @description MqController
 * @Date 2020/4/13 0013
 */
@RestController
public class MqController {
    @Autowired
    private RabbitProvider rabbitProvider;

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public String senmsg(String msg){
        rabbitProvider.send(msg);
        return "ok_"+msg;
    }
}
