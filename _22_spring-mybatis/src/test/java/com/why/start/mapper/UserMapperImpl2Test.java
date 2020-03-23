package com.why.start.mapper;

import com.why.start.pojo.User;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

import static org.junit.Assert.*;

public class UserMapperImpl2Test {

    @Test
    public void selectUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConText.xml");
        final UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        final List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void addUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConText.xml");
        final UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        int i = userMapper.addUser(new User(7,"III","789632"));
        i = userMapper.addUser(new User(8,"JJJ","789632"));
        i = userMapper.addUser(new User(9,"KKK","789632"));
        selectUser();
    }

    @Test
    public void deleteUser() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConText.xml");
        final UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        final int i = userMapper.deleteUser(9);
        selectUser();
    }
}