package com.why.start.ssm.service.impl;

import com.why.start.ssm.mapper.BookMapper;
import com.why.start.ssm.pojo.Books;
import com.why.start.ssm.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService {

    //@Autowired
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public int insertBook(Books books) {
        return bookMapper.insertBook(books);
    }

    @Override
    public int delBookById(int id) {
        return bookMapper.delBookById(id);
    }

    @Override
    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    @Override
    public Books selectBookById(int id) {
        return bookMapper.selectBookById(id);
    }

    @Override
    public Books selectBookByName(String name) {
        return bookMapper.selectBookByName(name);
    }

    @Override
    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
