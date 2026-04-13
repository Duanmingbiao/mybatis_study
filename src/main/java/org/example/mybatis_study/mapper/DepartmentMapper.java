package org.example.mybatis_study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis_study.pojo.Department;

import java.util.List;
@Mapper
public interface DepartmentMapper {
    int insert(Department department);
    int deleteById(Long id);
    int updateById(Department department);
    List<Department> selectList();
    Department selectById(Long id);
}
