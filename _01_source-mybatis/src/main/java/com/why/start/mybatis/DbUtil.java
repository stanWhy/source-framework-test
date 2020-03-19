package com.why.start.mybatis;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbUtil {
    private static String driver;
    private static String url;
    private static String username;
    private static String password;

    static {
        driver = "com.mysql.jdbc.Driver";
        url = "jdbc:mysql://localhost:3306/test";
        username = "root";
        password = "wanghyongyu";
    }

    public static Connection open() {
        try {
            Class.forName(driver);
            System.out.println("数据库连接成功");
            return DriverManager.getConnection(url, username, password);
        } catch (Exception e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        open();
    }
}
