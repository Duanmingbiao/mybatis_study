package org.example.mybatis_study.ExceptioN;

import org.example.mybatis_study.utils.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * 处理所有未知异常（兜底）
     */
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        e.printStackTrace(); // 开发阶段用于排错（生产可去掉）
        return Result.error("系统异常：" + e.getMessage());
    }

    /**
     * 处理空指针异常
     */
    @ExceptionHandler(NullPointerException.class)
    public Result handleNullPointerException(NullPointerException e) {
        return Result.error("空指针异常，请检查数据");
    }

    /**
     * 处理运行时异常（业务异常常用）
     */
    @ExceptionHandler(RuntimeException.class)
    public Result handleRuntimeException(RuntimeException e) {
        return Result.error(e.getMessage());
    }
}