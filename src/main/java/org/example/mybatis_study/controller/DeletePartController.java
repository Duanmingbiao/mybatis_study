package org.example.mybatis_study.controller;

import org.example.mybatis_study.mapper.DepartmentMapper;
import org.example.mybatis_study.service.DepartmentServiceImpl;
import org.example.mybatis_study.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class DeletePartController {
    @Autowired
    private DepartmentServiceImpl departmentServiceImpl;
    @DeleteMapping("/deletePart/{partId}")
    public Result deletePart(@PathVariable Long partId) {
        boolean delete = departmentServiceImpl.delete(partId);
        return Result.success("删除成功");
    }
}
