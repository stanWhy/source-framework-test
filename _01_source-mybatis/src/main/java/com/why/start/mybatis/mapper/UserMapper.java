package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    List<User> getUserList();

    User getUserById(int id);

    List<User> getUserById2(Map<String,Object> map);

    int insertUser(User user);

    int insertUser2(Map<String,Object> map);

    int updateUser(User user);

    int deleteUser(int id);
}
