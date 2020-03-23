package com.why.start.spring.demo1;

//房东
public class Host implements Rent{
    @Override
    public void rent() {
        System.out.println("A房东想要出租房子");
    }
}
