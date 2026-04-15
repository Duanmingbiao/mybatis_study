package org.example.mybatis_study.controller;

import org.example.mybatis_study.pojo.Result;
import org.example.mybatis_study.pojo.User;
import org.example.mybatis_study.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

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
    public Result list(@RequestParam(defaultValue = "1") Integer pageNum,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String name) {
        return Result.success(userServiceImpl.pageBean(pageNum, pageSize,name));
    }

    /**
     * 根据ID查询用户
     * GET /user/1
     */
//    @GetMapping("/{id}")
//    public Result getById(@PathVariable Long id) {
//        return Result.success(userServiceImpl.selectById(id));
//    }
    @GetMapping("/{id}")
    public Result getById(@PathVariable("id") Long id){
        return Result.success(userServiceImpl.selectById(id));
    }

    /**
     * 新增用户
     * POST /user
     */
    @PostMapping
    public Result add(@RequestBody User user) {
        int result = userServiceImpl.insert(user);
        return result > 0 ? Result.success("新增成功") : Result.error("新增失败");
    }

    /**
     * 修改用户
     * PUT /user
     */
    @PutMapping
    public Result update(@RequestBody User user) {
        int result = userServiceImpl.updateById(user);
        return result > 0 ? Result.success("修改成功") : Result.error("修改失败");
    }

    /**
     * 删除用户
     * DELETE /user/1
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id) {
        int result = userServiceImpl.deleteById(id);
        return result > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }
}
