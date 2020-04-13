package com.rabbitmq.provider;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author yunfei
 * @description RabbitProvider
 * @Date 2020/4/12 0012
 */
@Component
public class RabbitProvider {

    @Autowired
    private AmqpTemplate amqpTemplate;

    public void send(String msg) {
        String context = msg + new Date();
        System.out.println("Provider: " + context);
        amqpTemplate.convertAndSend("MyMq", context);
    }
}
