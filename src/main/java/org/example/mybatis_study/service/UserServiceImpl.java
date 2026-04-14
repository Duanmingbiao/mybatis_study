package org.example.mybatis_study.service;

import org.example.mybatis_study.mapper.UserMapper;
import org.example.mybatis_study.pojo.PageBean;
import org.example.mybatis_study.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserMapper userMapper;

    public int insert(User user) {
        return userMapper.insert(user);
    }

    public int deleteById(Long id) {
        return userMapper.deleteById(id);
    }
    public int updateById(User user) {
        return userMapper.updateById(user);
    }

    public List<User> selectList(Integer pageNum,Integer pageSize,String name) {
        return  userMapper.selectList(pageNum,pageSize,name);
    }

    public User selectById(Long id) {
        return userMapper.selectById(id);
    }
    public Long count(){
        return userMapper.count();
    }
    public PageBean pageBean(Integer pageNum, Integer pageSize, String name){
        Long count = userMapper.count();
        Integer start = (pageNum - 1) * pageSize;
        List<User> users = userMapper.selectList(start, pageSize,name);
        return new PageBean(count,users);
    }
}
