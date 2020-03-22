package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.Student;
import com.why.start.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class StudentMapperTest {

    @Test
    public void test(){
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            final List<Student> student = mapper.getStudent();
            for (Student student1 : student) {
                System.out.println(student1);
            }
        }
    }


    @Test
    public void getStudent2() {
        try(final SqlSession sqlSession = MybatisUtils.getSqlSession()){
            final StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
            final List<Student> student2 = mapper.getStudent2();
            for (Student student : student2) {
                System.out.println(student);
            }
        }
    }
}