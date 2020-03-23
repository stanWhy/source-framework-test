package com.why.start.spring.service;

public class UserServiceImpl implements UserService{
    @Override
    public void add() {
        System.out.println("增加一条数据");
    }

    @Override
    public void del() {
        System.out.println("删除一条数据");
    }

    @Override
    public void update() {
        System.out.println("修改一条数据");
    }

    @Override
    public void select() {
        System.out.println("查询一条数据");
    }
}