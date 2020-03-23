package com.why.start.spring.demo1;

public class Proxy implements Rent{

    private Host host;

    public Proxy(Host host){
        this.host = host;
    }

    @Override
    public void rent() {
        host.rent();
    }

    public void seeHouse(){
        System.out.println("中介带你看房");
    }
    public void hetong(){
        System.out.println("签租赁合同");
    }
    public void fare(){
        System.out.println("中介收中介费");
    }
}
