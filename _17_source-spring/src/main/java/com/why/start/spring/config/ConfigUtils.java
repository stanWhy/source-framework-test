package com.why.start.spring.config;

import com.why.start.spring.pojo.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfigUtils {

    /**
     * 注册一个bean，就相当于我们之前写的一个bean标签
     * 这个方法的名字，就相当于bean标签中的id属性
     * 这个方法的返回值，就相当于bean标签中的class属性
     * @return
     */
    @Bean
    public User getUser(){
        return new User();
    }
}
