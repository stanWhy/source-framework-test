```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xsi:schemaLocation="http://www.springframework.org/schema/beans
       http://www.springframework.org/schema/beans/spring-beans.xsd
       http://www.springframework.org/schema/context
       http://www.springframework.org/schema/context/spring-context.xsd">

    <!--    开启注解的支持-->
    <context:annotation-config/>
    <!--    指定要扫描的包，这个包下的注解就会生效-->
    <context:component-scan base-package="com.why.start.spring"/>
</beans>
```

##等价于<bean id="user" class="com.why.start.spring.pojo.User"/>
###@Component 组件

@Value("why-value")
相当于<property name="name" value="why-value"/>

衍生注解
@Component 有几个衍生注解，我们在web开发中，会按照mvc三层架构分层
    dao         【@Repository】
    service     【@Service】
    controller  【@Controller】
这四个注解功能都是一样的，都是代表将某个类注册到spring中，装配bean