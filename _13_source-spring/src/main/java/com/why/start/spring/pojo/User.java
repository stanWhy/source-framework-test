package com.why.start.spring.pojo;

import lombok.Data;

@Data
public class User {
    private String name;
    private Integer id;
    public User(Integer id,String name){
        this.id = id;
        this.name = name;
    }

    private User(){
        System.out.println("User 的无参构造");
    }

    public User(String name){
        this.name = name;
    }

    public User(Integer id){
        this.id = id;
    }

    public void show(){
        System.out.println("name："+name);
        System.out.println("id: "+id);
    }
}
