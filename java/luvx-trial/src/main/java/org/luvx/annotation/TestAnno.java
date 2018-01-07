package org.luvx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * 自定义注解
 */
//注解在运行时保留
@Retention(RetentionPolicy.RUNTIME)
//注解只能作用在方法上
@Target(ElementType.METHOD)
public @interface TestAnno {

}
