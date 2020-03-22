package com.why.start.spring.service.impl;

import com.why.start.spring.dao.impl.UserDaoByMysqlImpl;
import com.why.start.spring.dao.impl.UserDaoByOracleImpl;
import com.why.start.spring.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceBySetImplTest {

    @Test
    public void getUser() {
        UserServiceBySetImpl userService = new UserServiceBySetImpl();
        userService.setUserService(new UserDaoByOracleImpl());
        userService.getUser();
        userService.setUserService(new UserDaoByMysqlImpl());
        userService.getUser();
    }
}