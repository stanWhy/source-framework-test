package com.why.start.spring.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void show() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) context.getBean("User1");
        user.show();
        user = (User) context.getBean("User2");
        user.show();
        user = (User) context.getBean("User3");
        user.show();
        user = (User) context.getBean("User4");
        user.show();
    }
}