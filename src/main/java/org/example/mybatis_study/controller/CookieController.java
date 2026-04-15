package org.example.mybatis_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_study.pojo.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RestController
public class CookieController {
    @GetMapping("/c1")
    public Result cookie1(HttpServletResponse response) {
        log.info("request:" + response);
        Cookie cookie = new Cookie("token", "abc123");
        cookie.setPath("/");          // 全站可用
        cookie.setMaxAge(3600);       // 1小时
        response.addCookie(cookie);
        return Result.success();
    }
}
