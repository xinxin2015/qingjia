package com.upc.database.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static Connection conn = null;
    public static Connection getConnection() {

        if (conn == null) {
            String url = "jdbc:mysql://211.87.185.51:9060/qingjia?useUnicode=true&characterEncoding=UTF-8";
            String password = "jszbx-web-5117";
            String username = "root";
            try {
                Class.forName("com.mysql.jdbc.Driver");
                conn = DriverManager.getConnection(url, username, password);
                return conn;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return conn;
    }
}
