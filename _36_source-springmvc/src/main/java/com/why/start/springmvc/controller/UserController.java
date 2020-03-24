package com.why.start.springmvc.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.why.start.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {

    @RequestMapping("/j1")
    @ResponseBody//加入这个注解，就不会走视图解析器
    public String json1() throws JsonProcessingException {

        User user1 = new User(1,"小王",10);
        User user2 = new User(1,"小王",10);
        User user3 = new User(1,"小王",10);
        User user4 = new User(1,"小王",10);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        final ObjectMapper objectMapper = new ObjectMapper();

        final String s = objectMapper.writeValueAsString(users);

        return s;
    }

    @RequestMapping("/j2")
    @ResponseBody//加入这个注解，就不会走视图解析器
    public String json2() throws JsonProcessingException {

        User user1 = new User(1,"小王",10);
        User user2 = new User(1,"小王",10);
        User user3 = new User(1,"小王",10);
        User user4 = new User(1,"小王",10);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);

        //对象转json
        final String s = JSON.toJSONString(users);

        //json转java对象
        final List list = JSON.parseObject(s, List.class);
        System.out.println(list);

        //java对象转json对象
        final JSONObject o = (JSONObject) JSON.toJSON(user1);
        System.out.println(o);
        //json对象转java对象
        final User user = JSON.toJavaObject(o, User.class);
        System.out.println(user);
        return s;
    }

}
