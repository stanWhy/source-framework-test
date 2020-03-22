package com.why.start.spring.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.Assert.*;

public class HelloTest {
    @Test
    public void test1(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        Hello hello = (Hello) context.getBean("Hello");
        hello.setStr("abc");
        System.out.println(hello.toString());
    }

}