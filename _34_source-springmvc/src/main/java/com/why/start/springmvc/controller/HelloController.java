package com.why.start.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

    //真实访问地址：项目名/hello
    @RequestMapping("/hello")
    public String hello(Model model){
        //向模型中添加属性msg与值，可以在jsp页面中取出来并渲染
        model.addAttribute("msg","Hello SpringMVCAnnotation ! ");
        //WEB-INF/jsp/hello.jsp
        return "hello";
    }
}
