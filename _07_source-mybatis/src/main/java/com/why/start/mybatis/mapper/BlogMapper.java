package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.Blog;

import java.util.List;
import java.util.Map;

public interface BlogMapper {

    int addBlog(Blog blog);

    List<Blog> queryBlogIF(Blog blog);

    List<Blog> queryBlogChoose(Blog blog);

    int updateBlog(Blog blog);

    List<Blog> queryBlogForeach(Map map);
}
