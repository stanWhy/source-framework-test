package com.why.start.ssm.service;

import com.why.start.ssm.mapper.BookMapper;
import com.why.start.ssm.pojo.Books;
import com.why.start.ssm.service.impl.BookServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    @Test
    public void insertBook() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final int i = mapper.insertBook(new Books(1, "A书籍", 200, "A书籍"));
        if(i == 1)
            System.out.println("插入成功");
        queryAllBook();

    }

    @Test
    public void delBookById() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final int i = mapper.delBookById(4);
        if(i == 1)
            System.out.println("删除成功");
        queryAllBook();
    }

    @Test
    public void updateBook() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final int i = mapper.updateBook(new Books(6,"B书籍", 200, "A书籍"));
        if(i == 1)
            System.out.println("更新成功");
        queryAllBook();
    }

    @Test
    public void selectBookById() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final Books books = mapper.selectBookById(2);
        System.out.println(books);
    }

    @Test
    public void queryAllBook() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final List<Books> list = mapper.queryAllBook();
        for (Books books : list) {
            System.out.println(books);
        }
    }
}