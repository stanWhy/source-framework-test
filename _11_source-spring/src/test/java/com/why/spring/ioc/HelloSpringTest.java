package com.why.spring.ioc;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringTest {


    //@Test
    /*public void hello(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.getBean(HelloSpring.class);
    }*/

    @Test
    public void hello2(){
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        context.getBean("driver");
    }
}
