package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.Teacher;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            final List<Teacher> teacher = mapper.getTeacher();
            for (Teacher teacher1 : teacher) {
                System.out.println(teacher1);
            }
        }
    }

    @Test
    public void getTeacherById(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            final Teacher teacherById = mapper.getTeacherById(1);
            System.out.println(teacherById);
        }
    }

    @Test
    public void getTeacherById2(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            final Teacher teacherById2 = mapper.getTeacherById2(1);
            System.out.println(teacherById2);
        }
    }
}