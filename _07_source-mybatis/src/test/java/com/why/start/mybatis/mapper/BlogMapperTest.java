package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.Blog;
import com.why.start.mybatis.util.IDutils;
import com.why.start.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.*;

public class BlogMapperTest {

    @Test
    public void addBlog() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            mapper.addBlog(new Blog(IDutils.getId(),"mybatis如此简单","why",new Date(),9999));
            mapper.addBlog(new Blog(IDutils.getId(),"java如此简单","why",new Date(),99));
            mapper.addBlog(new Blog(IDutils.getId(),"spring如此简单","why",new Date(),999));
            mapper.addBlog(new Blog(IDutils.getId(),"微服务如此简单","why",new Date(),888));

        }
    }

    @Test
    public void queryBlogIF() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setId("72d62a14296546598b55ec80ec5ef236");
            final List<Blog> blogs = mapper.queryBlogIF(blog);
            for (Blog blog1 : blogs) {
                System.out.println(blog1);
            }
        }
    }

    @Test
    public void queryBlogChoose() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Blog blog = new Blog();
            blog.setAuthor("why");
            blog.setTitle("spring如此简单");
            final List<Blog> blogs = mapper.queryBlogChoose(blog);
            for (Blog blog1 : blogs) {
                System.out.println(blog1);
            }
        }
    }

    @Test
    public void queryBlogForeach() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final BlogMapper mapper = sqlSession.getMapper(BlogMapper.class);
            Map<String,Object> map = new HashMap<>();
            final ArrayList<Integer> ids = new ArrayList<>();
            ids.add(1);
            ids.add(2);
            ids.add(3);
            map.put("ids",ids);
            final List<Blog> blogs = mapper.queryBlogForeach(map);
            for (Blog blog : blogs) {
                System.out.println(blog);
            }
        }
    }
}