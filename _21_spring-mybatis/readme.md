#spring与mybatis整合
```xml
<dependencies>
    <dependency>
        <groupId>junit</groupId>
        <artifactId>junit</artifactId>
        <version>4.13</version>
        <scope>test</scope>
    </dependency>
    <dependency>
        <groupId>mysql</groupId>
        <artifactId>mysql-connector-java</artifactId>
        <version>8.0.19</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis</artifactId>
        <version>3.5.4</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-webmvc</artifactId>
        <version>5.2.3.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.springframework</groupId>
        <artifactId>spring-jdbc</artifactId>
        <version>5.2.3.RELEASE</version>
    </dependency>
    <dependency>
        <groupId>org.aspectj</groupId>
        <artifactId>aspectjweaver</artifactId>
        <version>1.9.5</version>
    </dependency>
    <dependency>
        <groupId>org.mybatis</groupId>
        <artifactId>mybatis-spring</artifactId>
        <version>2.0.3</version>
    </dependency>
</dependencies>
```

#mybatis
    1、编写实体类
    2、编写和新配置文件
    3、编写接口
    4、编写Mapper.xml
    5、测试
    
#mybatis-spring
    1、编写数据源配置
    2、sqlSessionFactory
    3、sqlSessionTimplate
    4、需要给接口加实现类
    5、将自己写的实现类，注入到Spring中
    6、测试
    
#配置更改
    1.数据源管理，由原来mybatis切换到spring
```xml
    <!--    1. 由原来mybatis-config.xml配置数据源 ， 切换为applicationConfig.xml 来管理数据源  -->
    <!--可以配置多套环境，使用哪个就在<environments default="">中切换哪个-->
    <environments default="test">
        <environment id="test">
            <transactionManager type="JDBC"/>
            <dataSource type="POOLED">
                <property name="driver" value="${driver}"/>
                <property name="url" value="${url}"/>
                <property name="username" value="${username}"/>
                <property name="password" value="${password}"/>
            </dataSource>
        </environment>
    </environments>
<!--    切换为applicationConfig.xml 来管理数据源   -->

<!--
    DataSource:使用spring的数据源替换mybatis的配置
    我们这里使用spring提供的jdbc
    -->
    <bean id="datasource" class="org.springframework.jdbc.datasource.DriverManagerDataSource">
        <property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
        <property name="url" value="jdbc:mysql://localhost:3306/mybatis?useSSL=true&amp;useUnicode=true&amp;characterEncoding=UTF-8&amp;serverTimezone=UTC"/>
        <property name="username" value="root"/>
        <property name="password" value="wanghongyu"/>
     </bean>
```
    2.SqlSessionFactory由手写工具类切换到spring管理
```java
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

```
切换到
```xml
<!--    sqlSessionFactory-->
    <bean id="sqlSeesionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="datasource"/>
    </bean>
```