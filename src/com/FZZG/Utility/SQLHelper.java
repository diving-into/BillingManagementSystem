package com.FZZG.Utility;

import java.sql.*;
import java.util.ResourceBundle;

public class SQLHelper {

    static  String driver = null;
    static String url = null;
    static String username = null;
    static String password = null;

    static Connection conn = null;
    static PreparedStatement ps = null;
    static ResultSet rs = null;

    static {
        try {
            readConfig();
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            System.out.println("数据库连接失败");
            e.printStackTrace();
        }
        System.out.println("数据库连接成功");
    }

    public static Connection getConnection() {
        try {
            conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    public static void readConfig() {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        driver = rb.getString("driver");
        url = rb.getString("url");
        username = rb.getString("user");
        password = rb.getString("password");
    }
    public static void close(Connection conn, PreparedStatement ps, ResultSet rs) {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (ps != null) {
            try {
                ps.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if (rs != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
