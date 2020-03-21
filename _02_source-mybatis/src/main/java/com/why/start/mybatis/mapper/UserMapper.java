package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;

import java.util.List;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    int insertUser(User user);

    int updateUser(User user);

    int deleteUser(int id);
}
