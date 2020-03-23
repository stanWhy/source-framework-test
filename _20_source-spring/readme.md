用spring实现AOP
1.使用aop织入，导入一个依赖
```xml
<dependencies>
        <dependency>
            <groupId>org.springframework</groupId>
            <artifactId>spring-webmvc</artifactId>
            <version>5.2.3.RELEASE</version>
        </dependency>
        <dependency>
            <groupId>org.aspectj</groupId>
            <artifactId>aspectjweaver</artifactId>
            <version>1.9.5</version>
        </dependency>
    </dependencies>
```

方式一：使用spring的api接口【主要SpringAPI接口实现】
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="com.why.start.spring.service.UserServiceImpl"/>
    <bean id="beforeLog" class="com.why.start.spring.util.BeforeLog"/>
    <bean id="afterLog" class="com.why.start.spring.util.AfterLog"/>

<!--    方式一：使用原生spring api接口-->
    <!--注册aop :需要导入aop的约束-->
    <aop:config>
        <!--配置切入点: expression:表达式，execution(要执行的位置)-->
        <aop:pointcut id="pointcut" expression="execution(* com.why.start.spring.service.UserService.*(..))"/>
<!--        执行环绕增强-->
        <aop:advisor advice-ref="beforeLog" pointcut-ref="pointcut"/>
    </aop:config>
</beans>
```
方式二：自定义实现AOP【主要是切面定义】
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="com.why.start.spring.service.UserServiceImpl2"/>
    <bean id="beforeLog" class="com.why.start.spring.util.BeforeLog"/>
    <bean id="afterLog" class="com.why.start.spring.util.AfterLog"/>

<!--    方式二：自定义类-->
    <bean id="diy" class="com.why.start.spring.util.DiyPointCut"/>
    <aop:config>
<!--        自定义切面，ref要引用的类-->
        <aop:aspect ref="diy">
<!--            切入点-->
            <aop:pointcut id="point" expression="execution(* com.why.start.spring.service.UserService.*(..))"/>
<!--            通知-->
            <aop:before method="before" pointcut-ref="point"/>
            <aop:after method="after" pointcut-ref="point"/>
        </aop:aspect>
    </aop:config>
</beans>
```
方式三：使用注解实现

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:aop="http://www.springframework.org/schema/aop"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/aop
       https://www.springframework.org/schema/aop/spring-aop.xsd">

    <bean id="userService" class="com.why.start.spring.service.UserServiceImpl3"/>
    <bean id="beforeLog" class="com.why.start.spring.util.BeforeLog"/>
    <bean id="afterLog" class="com.why.start.spring.util.AfterLog"/>
    
    <!--    方式三：-->
    <bean id="annocationPoinCut" class="com.why.start.spring.util.AnnotationPointCut"/>
    <!--    开启注解支持-->
    <aop:aspectj-autoproxy/>
</beans>
```
```java
package com.why.start.spring.util;
//方式三：使用注解方式实现AOP

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect//标注这个类是个切面
public class AnnotationPointCut {

    @Before("execution(* com.why.start.spring.service.UserServiceImpl3.*(..))")
    public void beafore(){
        System.out.println("===方法执行前===");
    }
    @After("execution(* com.why.start.spring.service.UserServiceImpl3.*(..))")
    public void after(){
        System.out.println("===方法执行后===");
    }
}
```