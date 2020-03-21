package com.why.start.mybatis.pojo;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String name;
    private String pwd;
    public User(){}
    public User(Integer id, String name, String pwd){
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }
}
