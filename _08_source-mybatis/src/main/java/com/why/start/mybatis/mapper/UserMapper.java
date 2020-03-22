package com.why.start.mybatis.mapper;

import com.why.start.mybatis.pojo.User;
import org.apache.ibatis.annotations.Param;



public interface UserMapper {

    User queryById(@Param("id") int id);
}
