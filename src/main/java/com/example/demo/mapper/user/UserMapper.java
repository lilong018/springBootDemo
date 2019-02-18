package com.example.demo.mapper.user;

import com.example.demo.domain.user.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    public List<User> selectUserList();

    public int insertUser(User user);

    public User selectUserById(Long userId);

    public int updateUser(User user);

    public int deleteUser(Long userId);

    public int deleteUserByIds(Long[] userIds);
}
