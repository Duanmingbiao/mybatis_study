package org.example.mybatis_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_study.pojo.Result;
import org.example.mybatis_study.pojo.User;
import org.example.mybatis_study.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping
public class LoginController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    @PostMapping("/login")
    public Result login(@RequestBody User user) {
        log.info("员工登录信息：" + user);
        User u = userServiceImpl.login(user);
        return (u != null ? Result.success("登录成功") : Result.error("登录失败")) ;
    }
}
