package org.example.mybatis_study.service;

import org.example.mybatis_study.mapper.UserMapper;
import org.example.mybatis_study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserMapper {
    @Autowired
    private UserMapper userMapper;

    @Override
    public int insert(User user) {
        return userMapper.insert(user);
    }

    @Override
    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    @Override
    public List<User> selectList() {
        return  userMapper.selectList();
    }

    @Override
    public User selectById(Long id) {
        return userMapper.selectById(id);
    }
}
