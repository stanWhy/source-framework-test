package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {


    @Test
    public void getUser() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final List<User> user = mapper.getUser();
            for (User user1 : user) {
                System.out.println(user1);
            }
        }
    }

    @Test
    public void getUserById(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final User userById = mapper.getUserById(1);
            System.out.println(userById);
        }
    }

    @Test
    public void insertUser(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int i = mapper.insertUser(new User(6,"HHH","789456"));
            if(i==1){
                final List<User> user = mapper.getUser();
                for (User user1 : user) {
                    System.out.println(user1);
                }
            }
        }
    }
}
