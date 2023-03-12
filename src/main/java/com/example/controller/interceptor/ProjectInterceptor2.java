package com.example.controller.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

@Component
public class ProjectInterceptor2 implements HandlerInterceptor {
    @Override//前置
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(handler.getClass());//获取其内存中类型而不是通过重写toString获得的假类型
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();//获取当前正在执行的方法对象
        System.out.println("preHandle2");//preHandle是请求来到控制器前执行,正着执行
        return true;
    }

    @Override//控制器返回后，能够成功响应(return)的情况 进而所有前置handle都return true的情况(不都return true你执行不了控制器中的响应),响应后执行(发生异常不执行)(ModelAndView响应的模型和视图)
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle2");//postHandle是控制器响应后执行,反着执行
    }

    @Override//拦截器返回真后,所属拦截器对应的preHandle完成后,不完成return true的不执行,无论是否成功响应(return)都执行(发生异常也执行)
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion2");
    }
}
