package org.example.mybatis_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_study.utils.JwtUtil;
import org.example.mybatis_study.utils.Result;
import org.example.mybatis_study.pojo.User;
import org.example.mybatis_study.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

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
        if(u != null) {
            HashMap<String, Object> obj = new HashMap<>();
            obj.put("userId", u.getId());
            obj.put("userName", u.getUsername());
            String token = JwtUtil.createToken(obj);
            return Result.success(token);
        }
        return Result.error("用户名或者密码错误");
    }
}
