package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.Teacher;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import static org.junit.Assert.*;

public class TeacherMapperTest {

    @Test
    public void getTeacher() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
            final Teacher teacher = mapper.getTeacher(1);
            System.out.println(teacher);
        }
    }
}