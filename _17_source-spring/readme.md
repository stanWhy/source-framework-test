#完全使用注解替换配置文件--@Configuration
```java
//如果完全使用注解方式，我们只能通过AnnotationConfigApplicationContext上下文来获取容器，通过配置类的class对象加载
ApplicationContext context = new AnnotationConfigApplicationContext(ConfigUtils.class);

```