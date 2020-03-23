package com.why.start.mapper;

import com.why.start.pojo.User;
import com.why.start.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import java.util.List;

import static org.junit.Assert.*;

public class UserMapperTest {

    @Test
    public void selectUser() {
        /*final SqlSession sqlSession = MybatisUtils.getSqlSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final List<User> users = mapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }*/

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationConText.xml");
        final UserMapper userMapper = context.getBean("userMapper", UserMapper.class);
        final List<User> users = userMapper.selectUser();
        for (User user : users) {
            System.out.println(user);
        }
    }
}