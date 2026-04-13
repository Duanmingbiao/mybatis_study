package org.example.mybatis_study.controller;

import org.example.mybatis_study.mapper.UserMapper;
import org.example.mybatis_study.pojo.User;
import org.example.mybatis_study.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;
    /**
     * 查询所有用户
     * GET /user/list
     */
    @GetMapping("/list")
    public List<User> list() {
        return userServiceImpl.selectList();
    }

    /**
     * 根据ID查询用户
     * GET /user/1
     */
    @GetMapping("/{id}")
    public User getById(@PathVariable Long id) {
        return userServiceImpl.selectById(id);
    }

    /**
     * 新增用户
     * POST /user
     */
    @PostMapping
    public String add(@RequestBody User user) {
        int result = userServiceImpl.insert(user);
        return result > 0 ? "新增成功" : "新增失败";
    }

    /**
     * 修改用户
     * PUT /user
     */
    @PutMapping
    public String update(@RequestBody User user) {
        int result = userServiceImpl.updateById(user);
        return result > 0 ? "修改成功" : "修改失败";
    }

    /**
     * 删除用户
     * DELETE /user/1
     */
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        int result = userServiceImpl.deleteById(id);
        return result > 0 ? "删除成功" : "删除失败";
    }
}
