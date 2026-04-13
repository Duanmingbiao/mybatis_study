package org.example.mybatis_study.controller;

import org.example.mybatis_study.pojo.Department;
import org.example.mybatis_study.pojo.Result;
import org.example.mybatis_study.service.DepartmentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Department")
public class DepartmentController {
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @GetMapping("/list")
    public Result list(){
        return Result.success(departmentServiceImpl.selectList());
    };
    @GetMapping("/{id}")
    public Department getById(Long id){
        return departmentServiceImpl.selectById(id);
    }
    @PostMapping()
    public String add(@RequestBody Department department){
        int insert = departmentServiceImpl.insert(department);
        return insert > 0 ? "新增成功" : "新增失败";
    }
    @PutMapping()
    public String update(@RequestBody Department department){
        int update = departmentServiceImpl.updateById(department);
        return update > 0 ? "修改成功" : "修改失败";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id){
        int delete = departmentServiceImpl.deleteById(id);
        return  delete > 0 ? "删除成功" : "删除失败";
    }
}
