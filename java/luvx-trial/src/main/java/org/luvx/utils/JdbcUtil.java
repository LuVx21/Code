package org.luvx.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * JDBC工具类:使用dbcfg.properties配置文件
 */
public class JdbcUtil {

    private static String driverClass;
    private static String url;
    private static String user;
    private static String password;

    // 根据配置文件获取数据库连接和数据库信息
    static {
        try {
            ClassLoader cl = JdbcUtil.class.getClassLoader();
            InputStream in = cl.getResourceAsStream("dbcfg.properties");
            Properties props = new Properties();
            props.load(in);
            driverClass = props.getProperty("driverClass");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            in.close();
        } catch (IOException e) {
            throw new ExceptionInInitializerError("获取数据库配置文件信息失败");
        }
        try {
            Class.forName(driverClass);
        } catch (ClassNotFoundException e) {
            throw new ExceptionInInitializerError("加载驱动失败");
        }
    }

    // 连接数据库
    public static Connection getConnection() {
        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            return conn;
        } catch (Exception e) {
            throw new RuntimeException("链接数据库的url或用户名密码错误,请检查您的配置文件");
        }
    }

    // 释放资源
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            conn = null;
        }
    }
}
