package org.luvx.utilsTest;

import org.junit.Test;
import org.luvx.reflect.InnerClass;
import org.luvx.utils.ReflectUtils;

import java.util.HashMap;
import java.util.Map;

public class ReflectUtilsTest {

    /**
     * 测试用类构造函数
     */
    String className = "org.luvx.reflect.InnerClass";
    Class[] parameterTypes = {java.lang.String.class, java.lang.Integer.class};
    Object[] initargs = {"this is inner class", 18};

    /**
     * 测试用实例对象
     */
    InnerClass innerClass = new InnerClass("this is new instance!", 18);

    /**
     *
     */

    /**
     * 创建实例
     */
    @Test
    public void constructorNewInstanceTest() {
        InnerClass instance = (InnerClass) ReflectUtils.constructorNewInstance(className, parameterTypes, initargs);
        System.out.println(instance.getAstrofInner() + " : " + instance.getNum());
    }

    @Test
    public void getFieldValueTest() {
        Integer instance = (Integer) ReflectUtils.getFieldValue(innerClass, "num");
        System.out.println(instance);
    }

    @Test
    public void getPropertyTest() {
        Integer instance = (Integer) ReflectUtils.getProperty(innerClass, "num");
        System.out.println(instance);
    }

    @Test
    public void getBeanInfoPropertyTest() {
        String instance = (String) ReflectUtils.getBeanInfoProperty(innerClass, "num");
        System.out.println(instance);
    }

    @Test
    public void getPropertyUtilByNameTest() {
        Integer instance = (Integer) ReflectUtils.getPropertyUtilByName(innerClass, "num");
        System.out.println(instance);
    }

    @Test
    public void setBeanInfoPropertyTest() {
        ReflectUtils.setBeanInfoProperty(innerClass, "num", "19");
        System.out.println(innerClass.getNum());
    }

    @Test
    public void setPropertyUtilByNameTest() {
        ReflectUtils.setPropertyUtilByName(innerClass, "num", 19);
        System.out.println(innerClass.getNum());
    }

    @Test
    public void setPropertiesTest() {
        ReflectUtils.setProperties(innerClass, "num", new Integer(19));
        System.out.println(innerClass.getNum());
    }

    @Test
    public void setFieldValueTest() {
        ReflectUtils.setFieldValue(innerClass, "num", new Integer(19));
        System.out.println(innerClass.getNum());
    }

    @Test
    public void methodInvokeTest() {
        String str = (String) ReflectUtils.methodInvoke(className, "strAdd", parameterTypes, initargs, innerClass);
        System.out.println(str);

    }

    @Test
    public void compareBeanValueTest() {
        Map<String, String> map = new HashMap<String, String>();
        map.put("astrofInner", "key");
        map.put("num", "value");

        InnerClass instance1 = new InnerClass("haha", 10);
        InnerClass instance2 = new InnerClass("hehe", 11);

        String str = ReflectUtils.compareBeanValue(map, instance1, instance2);
        System.out.println(str);
    }

}
