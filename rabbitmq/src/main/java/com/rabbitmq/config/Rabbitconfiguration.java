package com.rabbitmq.config;


import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yunfei
 * @description Rabbitconfiguration
 * @Date 2020/4/12 0012
 */
@Configuration
public class Rabbitconfiguration {
    @Bean
    public Queue queue(){
        return new Queue("MyMq");
    }
}
