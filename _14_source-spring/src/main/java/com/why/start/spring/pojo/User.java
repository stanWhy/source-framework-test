package com.why.start.spring.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class User {
    private String name;
    private int age;

    public User(String name,int age){
        this.name = name;
        this.age = age;
    }
}
