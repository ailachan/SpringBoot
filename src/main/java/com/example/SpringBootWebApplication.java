package com.example;

import com.example.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.DefaultSingletonBeanRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.lang.reflect.Field;
import java.util.Map;

@SpringBootApplication
public class SpringBootWebApplication implements WebMvcConfigurer {

    @Autowired
    private ProjectInterceptor projectInterceptor;

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        ConfigurableApplicationContext context = SpringApplication.run(SpringBootWebApplication.class, args);

        ConfigurableListableBeanFactory beanFactory = context.getBeanFactory();

        //beanFactory接口提供getBean,控制反转由实现类提供
        Field singletonObjects = DefaultSingletonBeanRegistry.class.getDeclaredField("singletonObjects");

        singletonObjects.setAccessible(true);

        Map<String,Object> o = (Map<String, Object>) singletonObjects.get(beanFactory);

        o.entrySet().stream().filter(x -> x.getKey().startsWith("controller")).forEach(System.out::println);

    }

    //添加一个拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(projectInterceptor).addPathPatterns("/products");
    }
}
