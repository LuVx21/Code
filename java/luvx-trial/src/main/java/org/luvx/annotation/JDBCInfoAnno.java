package org.luvx.annotation;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * jdbc连接用注解
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface JDBCInfoAnno {

    String driverClass() default "com.mysql.jdbc.Driver";

    String url() default "jdbc:mysql://localhost:3306/test";

    String user() default "root";

    String password() default "root";
}
