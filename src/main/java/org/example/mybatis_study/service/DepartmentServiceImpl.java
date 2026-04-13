package org.example.mybatis_study.service;

import org.example.mybatis_study.mapper.DepartmentMapper;
import org.example.mybatis_study.pojo.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DepartmentServiceImpl implements DepartmentMapper {
    @Autowired
    private DepartmentMapper departmentMapper;
    @Override
    public int insert(Department department) {
        return departmentMapper.insert(department);
    }

    @Override
    public int deleteById(Long id) {
        return departmentMapper.deleteById(id);
    }

    @Override
    public int updateById(Department department) {
        return departmentMapper.updateById(department);
    }

    @Override
    public List<Department> selectList() {
        return departmentMapper.selectList();
    }

    @Override
    public Department selectById(Long id) {
        return departmentMapper.selectById(id);
    }
}
