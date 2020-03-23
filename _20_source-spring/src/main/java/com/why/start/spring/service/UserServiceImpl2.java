package com.why.start.spring.service;

public class UserServiceImpl2 implements UserService{
    @Override
    public void add() {
        System.out.println("自定义增加一条数据");
    }

    @Override
    public void del() {
        System.out.println("自定义删除一条数据");
    }

    @Override
    public void update() {
        System.out.println("自定义修改一条数据");
    }

    @Override
    public void select() {
        System.out.println("自定义查询一条数据");
    }
}