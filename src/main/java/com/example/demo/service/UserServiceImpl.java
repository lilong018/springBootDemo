package com.example.demo.service;

import com.example.demo.domain.user.User;
import com.example.demo.mapper.user.UserMapper;
import com.example.demo.utils.Convert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> selectUserList() {
        return userMapper.selectUserList();
    }

    @Override
    public int insertUser(User user) {
        int rows = userMapper.insertUser(user);
        return rows;
    }

   @Override
    public User selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }


    @Override
    public int deleteUserByIds(String ids) throws Exception {
        Long[] userIds = Convert.toLongArray(ids);
        return userMapper.deleteUserByIds(userIds);
    }
}
