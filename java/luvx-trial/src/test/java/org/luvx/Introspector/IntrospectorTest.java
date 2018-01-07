package org.luvx.Introspector;

import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;
import org.luvx.bean.User;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 内省
 */
public class IntrospectorTest {
    /**
     * 取出所有getter和setter方法
     *
     * @throws IntrospectionException 内省异常
     */
    @Test
    public void run01() throws IntrospectionException {
        BeanInfo bi = Introspector.getBeanInfo(User.class);
        PropertyDescriptor[] pdi = bi.getPropertyDescriptors();
        for (PropertyDescriptor pdor : pdi) {
            System.out.println(pdor);
        }
    }

    /**
     * 根据属性名取出getter和setter方法
     *
     * @throws IntrospectionException 内省异常
     */
    @Test
    public void run02() throws IntrospectionException {
        User user = new User();
        user.setUsername("LuVx");
        PropertyDescriptor pdi = new PropertyDescriptor("username", User.class);
        Method m = pdi.getReadMethod();
        Method m1 = pdi.getWriteMethod();
        System.out.println(m);
        System.out.println(m1);
    }

    /**
     * 使用beanutils获取属性值
     *
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    @Test
    public void run03() throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        User user = new User();
        user.setUsername("LuVx");
        String username = BeanUtils.getProperty(user, "username");
        System.out.println(username);
    }
}
