package org.example.mybatis_study.service;

import org.example.mybatis_study.mapper.DepartmentMapper;
import org.example.mybatis_study.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl{
    @Autowired
    private DepartmentMapper departmentMapper;
    
    public int insert(Department department) {
        return departmentMapper.insert(department);
    }

    
    public int deleteById(Long id) {
        return departmentMapper.deleteById(id);
    }

    
    public int updateById(Department department) {
        return departmentMapper.updateById(department);
    }

    
    public List<Department> selectList() {
        return departmentMapper.selectList();
    }

    
    public Department selectById(Long id) {
        return departmentMapper.selectById(id);
    }
}
