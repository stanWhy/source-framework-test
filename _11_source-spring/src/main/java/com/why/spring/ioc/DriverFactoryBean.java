package com.why.spring.ioc;

import org.springframework.beans.factory.FactoryBean;

import java.sql.DriverManager;

public class DriverFactoryBean implements FactoryBean {
    String driver;

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    @Override
    public Object getObject() throws Exception {
        return DriverManager.getDriver(driver);
    }

    @Override
    public Class<?> getObjectType() {
        return java.sql.Driver.class;
    }

    @Override
    public boolean isSingleton(){
        return true;
    }
}
