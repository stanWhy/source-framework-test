package com.why.start.spring.pojo;

import com.why.start.spring.config.ConfigUtils;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void test(){
        ApplicationContext context = new AnnotationConfigApplicationContext(ConfigUtils.class);
        final User user = context.getBean("getUser", User.class);
        System.out.println(user.getName());
    }

}