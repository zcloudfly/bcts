package com.bcts.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 * Author: 张云飞
 * Time  :20200405
 */
@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.bcts.service.admin.mapper")
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class,args);
    }
}
