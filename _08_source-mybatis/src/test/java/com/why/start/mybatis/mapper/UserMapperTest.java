package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void queryById() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User user = mapper.queryById(1);
            System.out.println(user);

            //手动清理缓存
            //sqlSession.clearCache();
            final User user1 = mapper.queryById(1);
            System.out.println(user1);
        }
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User user = mapper.queryById(1);
            System.out.println(user);

            //手动清理缓存
            //sqlSession.clearCache();
            final User user1 = mapper.queryById(1);
            System.out.println(user1);
        }
    }
}