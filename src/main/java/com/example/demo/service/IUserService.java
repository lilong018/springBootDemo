package com.example.demo.service;

import com.example.demo.domain.user.User;

import java.util.List;

public interface IUserService {
    public List<User> selectUserList();

    public int insertUser(User user);

    public User selectUserById(Long userId);

    public int updateUser(User user);

    public int deleteUserByIds(String ids) throws Exception;

}
