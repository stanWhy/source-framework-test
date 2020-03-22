package com.why.start.mybatis.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class IDutilsTest {

    @Test
    public void getId() {
        final String id = IDutils.getId();
        System.out.println(id);
    }
}