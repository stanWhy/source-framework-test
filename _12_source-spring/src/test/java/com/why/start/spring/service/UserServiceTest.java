package com.why.start.spring.service;

import com.why.start.spring.dao.impl.UserDaoByOracleImpl;
import com.why.start.spring.service.impl.UserServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserServiceTest {

    @Test
    public void getUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
         UserServiceImpl userServiceImpl = (UserServiceImpl) context.getBean("UserServiceImpl");
         userServiceImpl.getUser();
         userServiceImpl.setUserDao(new UserDaoByOracleImpl());
         userServiceImpl.getUser();
    }
}