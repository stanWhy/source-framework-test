package com.why.start.spring.demo2;

public class UserServiceProxy implements UserService {

    private UserServiceImpl userServiceImpl;

    public void setUserService(UserServiceImpl userServiceImpl){
        this.userServiceImpl = userServiceImpl;
    }


    @Override
    public void add() {
        log("add");
        userServiceImpl.add();
    }

    @Override
    public void del() {
        log("del");
        userServiceImpl.del();
    }

    @Override
    public void update() {
        log("update");
        userServiceImpl.update();
    }

    @Override
    public void select() {
        log("select");
        userServiceImpl.select();
    }

    public void log(String message){
        System.out.println("使用了"+message+"方法");
    }
}
