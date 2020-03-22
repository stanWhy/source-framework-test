package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TeacherMapper {

    List<Teacher> getTeacher();

    //获取指定老师下的老师及学生信息
    Teacher getTeacherById(@Param("id") int id);

    Teacher getTeacherById2(@Param("tid") int id);
}
