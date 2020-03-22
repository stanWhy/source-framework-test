package com.why.start.spring.dao.impl;

import com.why.start.spring.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void getUser() {
        System.out.println("从本地获取用户数据");
    }
}
