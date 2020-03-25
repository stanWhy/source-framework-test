package com.why.start.ssm.service;

import com.why.start.ssm.pojo.Books;

import java.util.List;

public interface BookService {
    int insertBook(Books books);
    int delBookById(int id);
    int updateBook(Books books);
    Books selectBookById(int id);
    Books selectBookByName(String name);
    List<Books> queryAllBook();
}
