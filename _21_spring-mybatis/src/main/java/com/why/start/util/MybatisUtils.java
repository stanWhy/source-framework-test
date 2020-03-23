package com.why.start.util;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisUtils {
    private static SqlSessionFactory sessionFactory;
    static{
        String resource = "mybatis-config.xml";
        try {
            InputStream inputStream = Resources.getResourceAsStream(resource);
            sessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //既然有了SqlSessionFactory，顾名思义，我们就可以从中获得SQLSession的实例了。
    //SQLSession完全包含了面向数据库执行SQL命令所需的所有方法
    public static SqlSession getSqlSession(){
        //设置自动开启事务
        return sessionFactory.openSession(true);
    }
}
