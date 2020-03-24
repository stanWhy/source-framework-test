package com.why.start.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class ModelController {

    @GetMapping("/t2")
    public String test2(Model model) {
        model.addAttribute("msg", "/WEB-INF/jsp/hello.jsp");
        //转发
        return "hello";
    }

    @GetMapping("/t3")
    public String test3(Model model) {
        model.addAttribute("msg", "/WEB-INF/jsp/hello.jsp");
        //重定向 index.jsp页面
        return "redirect:/index.jsp";
    }

    @GetMapping("/t4")
    public String test4(Model model) {
        model.addAttribute("msg", "/WEB-INF/jsp/hello.jsp");
        //重定向 到t2接口
        return "redirect:/t2";
    }
}
