package com.why.start.spring.service.impl;

import com.why.start.spring.service.UserService;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void getUser() {
        UserService userService = new UserServiceImpl();
        userService.getUser();
    }
}