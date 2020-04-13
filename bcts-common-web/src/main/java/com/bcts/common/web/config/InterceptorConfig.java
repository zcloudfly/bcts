package com.bcts.common.web.config;

import com.bcts.common.web.interceptor.ConstantsIntercepter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author yunfei
 * @description InterceptorConfig
 * @Date 2020/4/10 0010
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(new ConstantsIntercepter()).addPathPatterns("/**");
    }
}
