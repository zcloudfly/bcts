package com.rabbitmq.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yunfei
 * @description RabbitConsumer
 * @Date 2020/4/13 0013
 */
@RabbitListener(queues = "MyMq")
@Component
public class RabbitConsumer {

    @RabbitHandler
    public void process(String message) {
        System.out.println("Consumer: " + message);
    }
}
