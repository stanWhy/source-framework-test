package com.why.start.spring.pojo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
//等价于<bean id="user" class="com.why.start.spring.pojo.User"/>
//@Component 组件
@Component
//@Scope("singleton") 设置作用域
@Scope("prototype")
public class User {
    //相当于<property name="name" value="why-value"/>
    @Value("why-value")
    public String name;
}
