package com.why.start.spring.service;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final UserService userService = context.getBean("userService", UserService.class);
        userService.add();
    }

}