package com.why.start.spring.service.impl;

import com.why.start.spring.dao.impl.UserDaoByMysqlImpl;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceByConstructorImplTest {

    @Test
    public void getUser() {
        final UserServiceByConstructorImpl userServiceByConstructor =
                new UserServiceByConstructorImpl(new UserDaoByMysqlImpl());
        userServiceByConstructor.getUser();
    }
}