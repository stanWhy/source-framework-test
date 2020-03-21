package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoTest {


    @Test
    public void testSelect() {
        //1.获取SQLSession对象
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
            System.out.println("======================");
            User userById = mapper.getUserById(1);
            System.out.println(userById);
        }
    }

    @Test
    public void testSelect2(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            Map<String,Object> map = new HashMap<>();
            map.put("mapName","FFF");
            final List<User> userById2 = mapper.getUserById2(map);
            for (User user : userById2) {
                System.out.println(user);
            }

        }
    }

    @Test
    public void testInsert(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int res = mapper.insertUser(new User(4,"DDD","456789"));
            System.out.println("res --> "+res);
            if(res > 0){
                //提交事务
                sqlSession.commit();
            }
            System.out.println("=================查询==================");
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void testInsert2(){
        try (SqlSession sqlSession = MybatisUtils.getSqlSession()) {
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
                Map<String,Object> map = new HashMap<>();
                map.put("mapId",5);
                map.put("mapName","FFF");
                map.put("mapPwd","567891");
            int res = mapper.insertUser2(map);
            System.out.println("res --> "+res);
            if(res > 0){
                //提交事务
                sqlSession.commit();
            }
            System.out.println("=================查询==================");
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }

    @Test
    public void testUpdate(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            int eee = mapper.updateUser(new User(4, "EEE", "567891"));
            System.out.println(eee);
            if(eee>0){
                sqlSession.commit();
            }
            System.out.println("=================查询==================");
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }
    }
    @Test
    public void testDel(){
        try(SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            final int i = mapper.deleteUser(4);
            System.out.println(i);
            if(i>0){
                sqlSession.commit();
            }
            System.out.println("=================查询==================");
            List<User> userList = mapper.getUserList();
            for (User user : userList) {
                System.out.println(user);
            }
        }

    }
}