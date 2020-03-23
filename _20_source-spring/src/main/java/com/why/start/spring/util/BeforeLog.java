package com.why.start.spring.util;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

public class BeforeLog implements MethodBeforeAdvice {
    //method:要执行目标对象的方法
    //objects：参数（args）
    //o：目标对象（target）
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println(o.getClass().getName()+" 的 "+method.getName()+" 被执行了");
    }
}
