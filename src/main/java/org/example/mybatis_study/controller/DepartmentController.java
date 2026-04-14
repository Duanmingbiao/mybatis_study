package org.example.mybatis_study.controller;

import lombok.extern.slf4j.Slf4j;
import org.example.mybatis_study.pojo.Department;
import org.example.mybatis_study.pojo.Result;
import org.example.mybatis_study.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Logger;
@Slf4j
@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @GetMapping("/list")
    public Result list(){
        log.info("查询全部list");
        return Result.success(departmentServiceImpl.selectList());
    };
    @GetMapping("/{id}")
    public Department getById(@PathVariable Long id){
        return departmentServiceImpl.selectById(id);
    }
    @PostMapping()
    public Result add(@RequestBody Department department){
        int insert = departmentServiceImpl.insert(department);
        return insert > 0 ? Result.success("新增成功") : Result.error("新增失败") ;
    }
    @PutMapping()
    public Result update(@RequestBody Department department){
        int update = departmentServiceImpl.updateById(department);
        return update > 0 ? Result.success("修改成功") : Result.error("修改失败");
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Long id){
        int delete = departmentServiceImpl.deleteById(id);
        return  delete > 0 ? Result.success("删除成功") : Result.error("删除失败");
    }
}
