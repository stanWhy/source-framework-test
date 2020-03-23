package com.why.start.spring.demo2;

public class Client {

    public static void main(String[] args) {
        UserServiceProxy userServiceProxy = new UserServiceProxy();
        userServiceProxy.setUserService(new UserServiceImpl());
        userServiceProxy.add();
        userServiceProxy.del();
        userServiceProxy.update();
        userServiceProxy.select();
    }
}
