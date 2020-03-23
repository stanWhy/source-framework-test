package com.why.start.mapper;

import com.why.start.pojo.User;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class UserMapperImpl2 extends SqlSessionDaoSupport implements UserMapper{
    //原来我们所有的操作，都是用SqlSession来执行，
    //现在都是用SqlSessionTemplate
    /*private SqlSessionTemplate sqlSession;

    public void setSqlSession(SqlSessionTemplate sqlSession) {
        this.sqlSession = sqlSession;
    }
*/
    @Override
    public List<User> selectUser() {
        /*final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final List<User> users = mapper.selectUser();
        return users;*/
        final SqlSession sqlSession = getSqlSession();
        final UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        final List<User> users = mapper.selectUser();
        return users;
    }
}
