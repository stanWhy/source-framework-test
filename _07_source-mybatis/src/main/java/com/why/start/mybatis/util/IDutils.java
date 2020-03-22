package com.why.start.mybatis.util;

import java.util.UUID;

public class IDutils {

    public static String getId(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
