package org.luvx.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * jdbc连接用注解
 * 可以直接在jdbcutils中配置数据库信息
 * 不用使用配置文件
 *
 * 只是注解的使用demo
 * 开发中不推荐的链接用法
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JDBCInfoAnno {

    String driverClass() default "com.mysql.jdbc.Driver";

    String url() default "jdbc:mysql://localhost:3306/test";

    String user() default "root";

    String password() default "root";
}
