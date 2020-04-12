package com.bcts.service.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * 启动类
 * Author: 张云飞
 * Time  :20200405
 */
@EnableSwagger2
@SpringBootApplication(scanBasePackages = "com.bcts")
@EnableEurekaClient
@MapperScan("com.bcts.service.admin.mapper")
public class ServiceAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceAdminApplication.class,args);
    }
}
