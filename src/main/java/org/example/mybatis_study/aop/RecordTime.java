package org.example.mybatis_study.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RecordTime {
    @Around("execution(* org.example.mybatis_study.controller.*.* (..))")
    public Object record(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        Object proceed = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("花费时间" + (end-start));
        return proceed;
    }
}
