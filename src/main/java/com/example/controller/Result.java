package com.example.controller;

public class Result {
    private Object data;

    private Integer statusCode;

    private String msg;


    public Result() {
    }

    public Result(Integer statusCode, Object data) {
        this.data = data;
        this.statusCode = statusCode;
    }

    public Result(Integer statusCode, String msg, Object data) {
        this.data = data;
        this.statusCode = statusCode;
        this.msg = msg;
    }

    /**
     * 获取
     *
     * @return data
     */
    public Object getData() {
        return data;
    }

    /**
     * 设置
     *
     * @param data
     */
    public void setData(Object data) {
        this.data = data;
    }

    /**
     * 获取
     *
     * @return statusCode
     */
    public Integer getStatusCode() {
        return statusCode;
    }

    /**
     * 设置
     *
     * @param statusCode
     */
    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * 获取
     *
     * @return msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * 设置
     *
     * @param msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String toString() {
        return "Result{data = " + data + ", statusCode = " + statusCode + ", msg = " + msg + "}";
    }
}
