package com.why.start.mapper;

import com.why.start.pojo.User;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class UserMapperImpl implements UserMapper {
    //原来我们所有的操作，都是用SqlSession来执行，
    //现在都是用SqlSessionTemplate
    private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }

    @Override
    public List<User> selectUser() {
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final List<User> users = mapper.selectUser();
        return users;
    }
}
