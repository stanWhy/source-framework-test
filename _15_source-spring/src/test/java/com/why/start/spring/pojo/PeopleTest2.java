package com.why.start.spring.pojo;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PeopleTest2 {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans2.xml");
        final People2 people = context.getBean("people2", People2.class);
        people.getCat().shot();
        people.getDog().shot();
    }

}