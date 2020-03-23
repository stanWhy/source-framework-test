package com.why.start.spring.util;

import org.springframework.aop.AfterReturningAdvice;

import java.lang.reflect.Method;

public class AfterLog implements AfterReturningAdvice {
    //o:返回值（执行之后会拿到返回结果）
    //method:要执行目标对象的方法
    //objects:参数（args）
    //o1：目标对象（target）
    @Override
    public void afterReturning(Object o, Method method, Object[] objects, Object o1) throws Throwable {
        System.out.println("执行了："+method.getName()+"方法，返回结果："+o);
    }
}
