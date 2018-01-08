package org.luvx.annotation;

import org.junit.Ignore;
import org.junit.Test;

import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.DriverManager;

@Ignore
public class JDBCInfoAnnoTest {

    @JDBCInfoAnno(url = "jdbc:mysql://localhost:3306/java", password = "1121")
    public static Connection getConnection() throws Exception {
        Class clazz = JDBCInfoAnnoTest.class;
        Method m = clazz.getMethod("getConnection");

        //3.判断该方法上是否有 JDBCInfoAnno注解 若有的话获取
        if (m.isAnnotationPresent(JDBCInfoAnno.class)) {
            JDBCInfoAnno info = m.getAnnotation(JDBCInfoAnno.class);

            //4.获取注解四个属性
            String driverClass = info.driverClass();
            String url = info.url();
            String user = info.user();
            String password = info.password();

            //5.注册驱动
            Class.forName(driverClass);

            //6.获取连接
            return DriverManager.getConnection(url, user, password);
        }

        return null;
    }

    @Test
    public void run01() throws Exception {
        System.out.println(getConnection());
    }

}
