package com.example;

import com.example.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringBootWebApplication implements WebMvcConfigurer {

    @Autowired
    private ProjectInterceptor projectInterceptor;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebApplication.class, args);
    }

    //添加一个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/products");
    }
}
