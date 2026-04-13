package org.example.mybatis_study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.example.mybatis_study.pojo.User;

import java.util.List;
@Mapper
public interface UserMapper {
    int insert(User user);
    int deleteById(Long id);
    int updateById(User user);
    List<User> selectList();
    User selectById(Long id);
}
