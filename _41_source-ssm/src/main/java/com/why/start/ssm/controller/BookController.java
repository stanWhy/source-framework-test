package com.why.start.ssm.controller;

import com.why.start.ssm.pojo.Books;
import com.why.start.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    @Qualifier("BookServiceImpl")
    private BookService bookService;

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model){
        final Books books = bookService.selectBookByName(queryBookName);
        List<Books> list = new ArrayList<>();
        list.add(books);
        model.addAttribute("args",list);
        return "allBook";
    }

    //查询全部的书籍，并返回到一个书籍展示页面
    @RequestMapping("/allBook")
    public String list(Model model) {
        final List<Books> books = bookService.queryAllBook();
        model.addAttribute("args", books);
        return "allBook";
    }

    //跳转增加书籍页面
    @RequestMapping("/toAddBook")
    public String toAddPapper() {
        return "addBook";
    }

    //添加书籍请求
    @RequestMapping("/addBook")
    public String addBook(Books books) {
        bookService.insertBook(books);
        return "redirect:/book/allBook";
    }

    //跳转到修改页面
    @RequestMapping("/toUpdate/{id}")
    public String toUpdatepapper(@PathVariable int id,Model model) {
        final Books books = bookService.selectBookById(id);
        model.addAttribute("args",books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books){
        int i = bookService.updateBook(books);
        if(i== 1) {
            System.out.println("修改成功");
        }
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{id}")
    public String deleteBook(@PathVariable int id){
        final int i = bookService.delBookById(id);
        if(i== 1) {
            System.out.println("删除成功");
        }
        return "redirect:/book/allBook";
    }


}
