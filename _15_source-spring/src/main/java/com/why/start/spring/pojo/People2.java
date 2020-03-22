package com.why.start.spring.pojo;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class People2 {
    private String name;
    @Autowired
    private Dog2 dog;
    @Autowired
    private Cat2 cat;
}
