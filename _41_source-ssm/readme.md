#整合ssm框架步骤
#step1.整合mybatis层
##1.添加依赖
```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <parent>
        <artifactId>source-framework-test</artifactId>
        <groupId>com.why</groupId>
        <version>1.0-SNAPSHOT</version>
    </parent>
    <modelVersion>4.0.0</modelVersion>

    <artifactId>_41_source-ssm</artifactId>

    <dependencies>
        <dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
            <version>8.0.19</version>
        </dependency>
        <dependency>
            <groupId>com.mchange</groupId>
            <artifactId>c3p0</artifactId>
            <version>0.9.5.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>servlet-api</artifactId>
            <version>2.5</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet.jsp</groupId>
            <artifactId>jsp-api</artifactId>
            <version>2.2</version>
        </dependency>
        <dependency>
            <groupId>javax.servlet</groupId>
            <artifactId>jstl</artifactId>
            <version>1.2</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis</artifactId>
            <version>3.5.4</version>
        </dependency>
        <dependency>
            <groupId>org.mybatis</groupId>
            <artifactId>mybatis-spring</artifactId>
            <version>2.0.3</version>
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
    </dependencies>


    <build>
        <resources>
            <resource>
                <directory>src/main/resources</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
            <resource>
                <directory>src/main/java</directory>
                <includes>
                    <include>**/*.properties</include>
                    <include>**/*.xml</include>
                </includes>
                <filtering>true</filtering>
            </resource>
        </resources>
    </build>
</project>
```
##2.创建mybatis配置文件--mybatis-config.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>
    <!--    1.配置数据源，交给spring来做-->
    <!--    2.设置setting，可以忽略-->
    <settings>
        <setting name="logImpl" value="STDOUT_LOGGING"/>
    </settings>
    <!--    3.给实体类设置别名-->
    <typeAliases>
        <package name="com.why.start.ssm.pojo"/>
    </typeAliases>
    <!--    4.配置mapper映射，交给spring来做-->
    <mappers>
        <mapper resource="mybatis/BookMapper.xml"/>
    </mappers>
</configuration>
```
##3.创建数据库连接配置文件--database.properties
```properties
driver=com.mysql.cj.jdbc.Driver
url=jdbc:mysql://127.0.0.1:3306/ssmbuild?useSSL=true&useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC
user=root
password=wanghongyu
```
##4.创建Books，BookMapper
##5.创建BookMapper.xml
```xml
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<!--1.配置命名空间，指向BookMapper.class-->
<mapper namespace="com.why.start.ssm.mapper.BookMapper">

    <resultMap id="BookMapper" type="com.why.start.ssm.pojo.Books"/>

    <sql id="key">
        bookID,bookName,bookCounts,detail
    </sql>

    <insert id="insertBook" parameterType="Books">
        insert into books (bookName,bookCounts,detail)
        values (#{bookName},#{bookCounts},#{detail})
    </insert>

    <delete id="delBookById" >
        delete from books
        where       bookID = #{bookID}
    </delete>

    <update id="updateBook" parameterType="Books">
        update  books
        set     bookName = #{bookName},
                bookCounts = #{bookCounts},
                detail = #{detail}
        where   bookID = #{bookID}
    </update>

    <select id="selectBookById" resultType="Books">
        select  <include refid="key"/>
        from    books
        where   bookID = #{bookID}
    </select>

    <select id="queryAllBook" resultType="Books">
        select  <include refid="key"/>
        from    books
    </select>
</mapper>
```
##6.写service层
#step2.整合spring层
##1.spring整合dao配置文件spring-dao.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context https://www.springframework.org/schema/context/spring-context.xsd">

    <!--    1.关联数据库配置文件-->
    <context:property-placeholder location="classpath:database.properties"/>

    <!--    2.连接池-->
    <bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${driver}"/>
        <property name="jdbcUrl" value="${url}"/>
        <property name="user" value="${user}"/>
        <property name="password" value="${password}"/>
    </bean>

    <!--    3.SqlSessionFactory-->
    <bean id="sqlSessionFactory" class="org.mybatis.spring.SqlSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>
        <property name="configLocation" value="classpath:mybatis-config.xml"/>
    </bean>

    <!--    4.配置DAO接口扫描包，动态的实现了dao接口可以注入到spring中-->
    <bean class="org.mybatis.spring.mapper.MapperScannerConfigurer">
        <!--        要扫描的dao包-->
        <property name="basePackage" value="com.why.start.ssm.mapper"/>
        <!--        注入sqlSessionFactory-->
        <property name="sqlSessionFactoryBeanName" value="sqlSessionFactory"/>
    </bean>

</beans>
```
##2.sring整合service配置--spring-service.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd">

<!--    1.扫描service下的包-->
    <context:component-scan base-package="com.why.start.ssm.service"/>
<!--    2.将我们所有的业务类注入到spring，可以通过配置或注解实现-->
    <bean id="BookServiceImpl" class="com.why.start.ssm.service.impl.BookServiceImpl">
        <property name="bookMapper" ref="bookMapper"/>
    </bean>
<!--    3.声明式事务配置-->
    <bean id="transactionManager" class="org.springframework.jdbc.datasource.DataSourceTransactionManager">
<!--        注入数据源-->
        <property name="dataSource" ref="dataSource"/>
    </bean>
<!--    4.aop事务支持！-->
</beans>
```
##3.整合spring配置--applicationContext.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="classpath:spring-dao.xml"/>
    <import resource="classpath:spring-service.xml"/>
</beans>
```
#step3:编写测试类--BookServiceTest
```java
package com.why.start.ssm.service;

import com.why.start.ssm.mapper.BookMapper;
import com.why.start.ssm.pojo.Books;
import com.why.start.ssm.service.impl.BookServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static org.junit.Assert.*;

public class BookServiceTest {
    @Test
    public void insertBook() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final int i = mapper.insertBook(new Books(1, "A书籍", 200, "A书籍"));
        if(i == 1)
            System.out.println("插入成功");
        queryAllBook();

    }

    @Test
    public void delBookById() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final int i = mapper.delBookById(4);
        if(i == 1)
            System.out.println("删除成功");
        queryAllBook();
    }

    @Test
    public void updateBook() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final int i = mapper.updateBook(new Books(4,"B书籍", 200, "A书籍"));
        if(i == 1)
            System.out.println("更新成功");
        queryAllBook();
    }

    @Test
    public void selectBookById() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final Books books = mapper.selectBookById(4);
        System.out.println(books);
    }

    @Test
    public void queryAllBook() {
        final ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        final BookMapper mapper = context.getBean("bookMapper", BookMapper.class);
        final List<Books> list = mapper.queryAllBook();
        for (Books books : list) {
            System.out.println(books);
        }
    }
}
```
#step4
##1.变成web项目
##2.编写web.xml
```xml
<?xml version="1.0" encoding="UTF-8"?>
<web-app xmlns="http://xmlns.jcp.org/xml/ns/javaee"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://xmlns.jcp.org/xml/ns/javaee http://xmlns.jcp.org/xml/ns/javaee/web-app_4_0.xsd"
         version="4.0">
<!--    DispatchServlet-->
    <servlet>
        <servlet-name>springmvc</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
            <param-name>contextConfigLocation</param-name>
            <param-value>classpath:spring-mvc.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
    </servlet>
    <servlet-mapping>
        <servlet-name>springmvc</servlet-name>
        <url-pattern>/</url-pattern>
    </servlet-mapping>
<!--    乱码过滤-->
    <filter>
        <filter-name>encodingFilter</filter-name>
        <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
        <init-param>
            <param-name>encoding</param-name>
            <param-value>utf-8</param-value>
        </init-param>
    </filter>
    <filter-mapping>
        <filter-name>encodingFilter</filter-name>
        <url-pattern>/*</url-pattern>
    </filter-mapping>
<!--    session过期时间-->
    <session-config>
        <session-timeout>15</session-timeout>
    </session-config>
</web-app>
```
##3.写spring-mvc.xml配置
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
        http://www.springframework.org/schema/context
       https://www.springframework.org/schema/context/spring-context.xsd
        http://www.springframework.org/schema/mvc
       https://www.springframework.org/schema/mvc/spring-mvc.xsd">

<!--    1.注解驱动-->
    <mvc:annotation-driven/>
    <!--    2.静态资源过滤-->
    <mvc:default-servlet-handler/>
    <!--    3.扫描包：controller-->
    <context:component-scan base-package="com.why.start.ssm.controller"/>
    <!--    4.视图解析器-->
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver" id="internalResourceViewResolver">
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <property name="suffix" value=".jsp"/>
    </bean>
</beans>
```
#4.把spring-mvc.xml添加进applicationContext.xml中
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

    <import resource="classpath:spring-dao.xml"/>
    <import resource="classpath:spring-service.xml"/>
    <import resource="classpath:spring-mvc.xml"/>
</beans>
```