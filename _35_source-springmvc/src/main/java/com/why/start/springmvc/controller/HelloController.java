package com.why.start.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //传统请求方式：http://localhost:8080/test?a=1&b=2
    @RequestMapping("/test")
    public String test(Model model,int a,int b){
        int res = a+b;
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }

    //restful风格：http://localhost:8080/test2/1/2
    @RequestMapping("/test2/{a}/{b}")
    public String test2(Model model, @PathVariable int a,@PathVariable int b){
        int res = a+b;
        model.addAttribute("msg","结果为"+res);
        return "hello";
    }

}
