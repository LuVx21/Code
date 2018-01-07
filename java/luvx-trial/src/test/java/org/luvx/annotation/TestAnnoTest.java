package org.luvx.annotation;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class TestAnnoTest {

    @TestAnno
    public void fun1() {
        System.out.println("this is fun1");
    }

    public void fun2() {
        System.out.println("this is fun2");
    }

    @TestAnno
    public void fun3() {
        System.out.println("this is fun3");
    }

    /**
     * 执行被注解标注的方法
     *
     * @throws Exception
     */
    @Test
    public void run01() throws Exception {
        Class clazz = TestAnnoTest.class;
        Method[] arr = clazz.getMethods();

        for (Method m : arr) {
            boolean flag = m.isAnnotationPresent(TestAnno.class);
            if (flag) {
                m.invoke(clazz.newInstance());
            }
        }
    }
}
