package com.why.start.spring.demo2;

public class Client {
    public static void main(String[] args) {
        //真实角色
        UserServiceImpl2 userService = new UserServiceImpl2();

        //代理角色
        final ProxyInvocationhandler2 proxyInvocationhandler = new ProxyInvocationhandler2();
        //设置要代理的对象
        proxyInvocationhandler.setTarget(userService);
        //动态生成代理类
        UserService proxy = (UserService) proxyInvocationhandler.getProxy();

        proxy.add();
        proxy.del();
        proxy.update();
        proxy.select();

    }
}
