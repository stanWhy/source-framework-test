package com.why.start.spring.util;
//方式三：使用注解方式实现AOP

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//标注这个类是个切面
public class AnnotationPointCut {

    @Before("execution(* com.why.start.spring.service.UserServiceImpl3.*(..))")
    public void beafore(){
        System.out.println("===方法执行前===");
    }
    @After("execution(* com.why.start.spring.service.UserServiceImpl3.*(..))")
    public void after(){
        System.out.println("===方法执行后===");
    }

    @Around("execution(* com.why.start.spring.service.UserServiceImpl3.*(..))")
    public void around(ProceedingJoinPoint jp) throws Throwable {
        System.out.println("环绕前");
        //一定要加这句（声明是在哪个方法环绕）
        final Object o = jp.proceed();
        System.out.println("环绕后");
    }
}
