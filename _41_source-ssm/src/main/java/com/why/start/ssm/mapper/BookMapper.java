package com.why.start.ssm.mapper;

import com.why.start.ssm.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {
    int insertBook(Books books);
    int delBookById(@Param("bookID") int id);
    int updateBook(Books books);
    Books selectBookById(@Param("bookID")int id);
    List<Books> queryAllBook();
}
