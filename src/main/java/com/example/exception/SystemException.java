package com.example.exception;

//runtimeException由虚拟机运行时处理,一般直接抛到控制台,但此处还有异常处理器处理
public class SystemException extends RuntimeException {//继承Exception的话new出该异常后必须进行直接处理tryCatch或throw直接运行时抛出
    private Integer code;

    public SystemException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public SystemException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }
}
