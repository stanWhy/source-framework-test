package com.why.start.springmvc.controller;

import com.why.start.springmvc.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UserController {

    //http://localhost:8080/user/t1?name=abc
    @GetMapping("/user/t1")
    public String test1(String name, Model model){
        //1.接收前端参数
        System.out.println("接收到前端的参数为："+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        return "hello";
    }

    //http://localhost:8080/user/t2?username=abc
    @GetMapping("/user/t2")
    public String test2(@RequestParam("username") String name, Model model){
        //1.接收前端参数
        System.out.println("接收到前端的参数为："+name);
        //2.将返回的结果传递给前端
        model.addAttribute("msg",name);
        return "hello";
    }

    //http://localhost:8080/user/t3?id=1&name=why&age=10
    @GetMapping("/user/t3")
    public String test3(User user, Model model){
        //1.接收前端参数\

        System.out.println("接收到前端的参数为："+user.toString());
        //2.将返回的结果传递给前端
        model.addAttribute("msg",user.toString());
        return "hello";
    }

    @GetMapping("/user/t4")
    public String test4(ModelMap modelMap){


        return "hello";
    }
}
