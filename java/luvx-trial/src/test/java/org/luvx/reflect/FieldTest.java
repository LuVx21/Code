package org.luvx.reflect;

import org.junit.Test;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;


public class FieldTest {


    @Test
    public void run01() throws Exception {
        Class[] clazzs = InnerClass.class.getDeclaredClasses();
        Class clazz = clazzs[0];

        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            System.out.println(field);
            System.out.println(field.getGenericType());
            System.out.println(field.getModifiers());
            System.out.println(Modifier.toString(field.getModifiers()));
        }
    }
}
