package org.example.mybatis_study.utils;

public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    // 成功
    public static <T> Result<T> success(T data) {
        Result<T> result = new Result<>();
        result.code = 200;
        result.msg = "成功";
        result.data = data;
        return result;
    }

    // 成功（无数据）
    public static <T> Result<T> success() {
        Result<T> result = new Result<>();
        result.code = 200;
        result.msg = "成功";
        return result;
    }

    // 失败
    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<>();
        result.code = 500;
        result.msg = msg;
        return result;
    }

    // getter/setter
    public Integer getCode() { return code; }
    public void setCode(Integer code) { this.code = code; }

    public String getMsg() { return msg; }
    public void setMsg(String msg) { this.msg = msg; }

    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
}