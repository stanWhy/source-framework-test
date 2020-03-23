package com.why.start.spring.demo2;

public class UserServiceImpl2 implements UserService {
    @Override
    public void add() {
        System.out.println("动态代理增加一条数据");
    }

    @Override
    public void del() {
        System.out.println("动态代理删除一条数据");
    }

    @Override
    public void update() {
        System.out.println("动态代理修改一条数据");
    }

    @Override
    public void select() {
        System.out.println("动态代理查询一条数据");
    }
}
