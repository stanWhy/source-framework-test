package com.why.spring.ioc;

public class HelloSpring {
    private String name;
    private int sex;

    public HelloSpring(){

    }
    public HelloSpring(String name, int sex) {
        this.name = name;
        this.sex = sex;
    }

    public static HelloSpring build(){
        return new HelloSpring();
    }

    public static HelloSpring build(String type){
        if("A".equals(type)){
            return new HelloSpring("why",1);
        }else if("B".equals(type)){
            return new HelloSpring("aaa",2);
        }else{
            throw new IllegalArgumentException("参数错误");
        }
    }
}
