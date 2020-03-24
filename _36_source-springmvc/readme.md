#JSON
```html
//编写一个javascript对象 es6
        var user = {
            name : "abc",
            age:3,
            sex:"男"
        };
        console.log(user);

        //将js对象转化为json对象
        var s = JSON.stringify(user);
        console.log(s);

        //将json对象转化为js对象
        var parse = JSON.parse(s);
        console.log(parse)
```

解决jackson乱码问题
```xml
<!--    JSON乱码问题配置-->
    <mvc:annotation-driven>
        <mvc:message-converters register-defaults="true">
            <bean class="org.springframework.http.converter.StringHttpMessageConverter">
                <constructor-arg value="UTF-8"/>
            </bean>
            <bean class="org.springframework.http.converter.json.MappingJackson2HttpMessageConverter">
                <property name="objectMapper">
                    <bean class="org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean">
                        <property name="failOnEmptyBeans" value="false"/>
                    </bean>
                </property>
            </bean>
        </mvc:message-converters>
    </mvc:annotation-driven>
```