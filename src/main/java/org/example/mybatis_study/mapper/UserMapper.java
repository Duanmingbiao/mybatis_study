package org.example.mybatis_study.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.example.mybatis_study.pojo.User;

import java.time.LocalDateTime;
import java.util.List;
@Mapper
public interface UserMapper {
    int insert(User user);
    int deleteById(Long id);
    int updateById(User user);
    List<User> selectList(@Param("pageNum") Integer pageNum, @Param("pageSize") Integer pageSize, @Param("name") String name);
    User selectById(Long id);
    @Select("select count(*) from user")
    Long count();
}
