package com.why.start.spring.demo1;

//我
public class Client {
    public static void main(String[] args) {
        final Proxy proxy = new Proxy(new Host());
        proxy.seeHouse();
        proxy.rent();
        proxy.hetong();
        proxy.fare();
    }
}
