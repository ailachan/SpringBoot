package com.example.controller;

import com.example.exception.BusinessException;
import com.example.exception.SystemException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice//RestController异常通知类
public class ProjectExceptionActive {

    @ExceptionHandler(Exception.class)//捕获运行时抛出的没有转为或者没有被下面两种自定义异常处理器处理的其他异常
    public Result doException(Exception e){
        return new Result(Code.UNKNOWN_ERR,"未知异常",null);
    }

    @ExceptionHandler(SystemException.class)//选择捕获哪一种异常
    public Result doSystemException(SystemException e){
        return new Result(e.getCode(),e.getMessage(),null);
    }

    @ExceptionHandler(BusinessException.class)//选择捕获哪一种异常
    public Result doBusinessException(BusinessException e){
        return new Result(e.getCode(),e.getMessage(),null);
    }
}
