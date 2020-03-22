package com.why.start.spring.service.impl;

import com.why.start.spring.dao.UserDao;
import com.why.start.spring.dao.impl.UserDaoByMysqlImpl;
import com.why.start.spring.dao.impl.UserDaoByOracleImpl;
import com.why.start.spring.dao.impl.UserDaoImpl;
import com.why.start.spring.service.UserService;

public class UserServiceImpl implements UserService {
    @Override
    public void getUser() {
        UserDao userDao = new UserDaoImpl();
        userDao.getUser();
        userDao = new UserDaoByMysqlImpl();
        userDao.getUser();
        userDao = new UserDaoByOracleImpl();
        userDao.getUser();
    }
}
