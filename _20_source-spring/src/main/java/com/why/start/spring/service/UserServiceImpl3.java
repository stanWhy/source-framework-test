package com.why.start.spring.service;

public class UserServiceImpl3 implements UserService{
    @Override
    public void add() {
        System.out.println("注解增加一条数据");
    }

    @Override
    public void del() {
        System.out.println("注解删除一条数据");
    }

    @Override
    public void update() {
        System.out.println("注解修改一条数据");
    }

    @Override
    public void select() {
        System.out.println("注解查询一条数据");
    }
}