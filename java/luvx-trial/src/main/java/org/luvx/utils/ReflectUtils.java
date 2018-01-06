package org.luvx.utils;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;

/**
 * 问题:JDK5中不能传递二个可变参数,如:methodInvoke()方法
 */
public class ReflectUtils {

    /**
     * 通过构造函数实例化对象
     * 只能根据有参构造函数实例化
     *
     * @param className      类的全路径名称
     * @param parameterTypes 参数类型
     * @param initargs       参数值
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Object constructorNewInstance(String className, Class[] parameterTypes, Object[] initargs) {
        try {
            Constructor<?> constructor = (Constructor<?>) Class.forName(className).getDeclaredConstructor(parameterTypes);
            constructor.setAccessible(true);
            return constructor.newInstance(initargs);
        } catch (Exception ex) {
            throw new RuntimeException();
        }

    }

    /**
     * 暴力反射获取字段值
     * 使用反射自身方法
     *
     * @param obj          实例对象
     * @param propertyName 属性名
     * @return 属性值
     */
    public static Object getFieldValue(Object obj, String propertyName) {
        try {
            Field field = obj.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            return field.get(obj);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }


    /**
     * 暴力反射获取字段值
     * 使用PropertyDescriptor
     *
     * @param object       实例对象
     * @param propertyName 属性名
     * @return 字段值
     */
    public static Object getProperty(Object object, String propertyName) {
        try {

            PropertyDescriptor pd = new PropertyDescriptor(propertyName, object.getClass());
            Method method = pd.getReadMethod();
            return method.invoke(object);

            //其它方式
            /*
            BeanInfo beanInfo =  Introspector.getBeanInfo(object.getClass());
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            Object retVal = null;
            for(PropertyDescriptor pd : pds){
                if(pd.getName().equals(propertyName))
                {
                    Method methodGetX = pd.getReadMethod();
                    retVal = methodGetX.invoke(object);
                    break;
                }
            }
            return retVal;
            */
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 通过BeanUtils工具包获取反射获取字段值
     * 注意返回值是以字符串形式存在的,它支持属性连缀操作:如,.对象.属性
     *
     * @param propertyName 属性名
     * @param object       实例对象
     * @return 字段值
     */
    public static Object getBeanInfoProperty(Object object, String propertyName) {
        try {
            return BeanUtils.getProperty(object, propertyName);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 通过BeanUtils工具包获取反射获取字段值
     * 注意此值是以对象属性的实际类型
     *
     * @param propertyName 属性名
     * @param object       实例对象
     * @return 字段值
     */
    public static Object getPropertyUtilByName(Object object, String propertyName) {
        try {
            return PropertyUtils.getProperty(object, propertyName);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 通过BeanUtils工具包获取反射设置字段值
     * 注意此值是以字符串形式存在的
     *
     * @param object       实例对象
     * @param propertyName 属性名
     * @param value        字段值
     * @return
     */
    public static void setBeanInfoProperty(Object object, String propertyName, String value) {
        try {
            BeanUtils.setProperty(object, propertyName, value);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 通过BeanUtils工具包获取反射设置字段值
     * 注意此值是以对象属性的实际类型,这是PropertyUtils与BeanUtils的根本区别
     *
     * @param object       实例对象
     * @param propertyName 属性名
     * @param value        字段值
     * @return
     */
    public static void setPropertyUtilByName(Object object, String propertyName, Object value) {
        try {
            PropertyUtils.setProperty(object, propertyName, value);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 设置字段值
     *
     * @param object       实例对象
     * @param propertyName 属性名
     * @param value        新的字段值(实际对象类型)
     * @return
     */
    public static void setProperties(Object object, String propertyName, Object value) {
        try {
            PropertyDescriptor pd = new PropertyDescriptor(propertyName, object.getClass());
            Method methodSet = pd.getWriteMethod();
            methodSet.invoke(object, value);
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }


    /**
     * 设置字段值
     *
     * @param propertyName 字段名
     * @param obj          实例对象
     * @param value        新的字段值(实际对象类型)
     * @return
     */
    public static void setFieldValue(Object obj, String propertyName, Object value) {
        try {
            Field field = obj.getClass().getDeclaredField(propertyName);
            field.setAccessible(true);
            field.set(obj, value);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 执行方法
     *
     * @param className      类的全路径名称
     * @param methodName     调用方法名
     * @param parameterTypes 参数类型
     * @param values         参数值
     * @param object         实例对象
     * @return
     */
    @SuppressWarnings("rawtypes")
    public static Object methodInvoke(String className, String methodName, Class[] parameterTypes, Object[] values, Object object) {
        try {
            Method method = Class.forName(className).getDeclaredMethod(methodName, parameterTypes);
            method.setAccessible(true);
            return method.invoke(object, values);
        } catch (Exception ex) {
            throw new RuntimeException();
        }
    }

    /**
     * 比较两个bean的各个属性值是否不同
     *
     * @param <T>     具体对象
     * @param fileds  要进行比较Bean对象的属性值集合<属性名,属性描述>
     * @param oldBean 对象
     * @param newBean 对象
     * @return 返回二个Bean对象属性值的异同
     */
    public static <T> String compareBeanValue(Map<String, String> fileds, T oldBean, T newBean) {

        StringBuilder compares = new StringBuilder();
        String propertyName = null;
        Object oldPropertyValue = null;
        Object newPropertyValue = null;

        for (Map.Entry<String, String> entity : fileds.entrySet()) {
            propertyName = entity.getKey();
            oldPropertyValue = getProperty(oldBean, propertyName);
            newPropertyValue = getProperty(newBean, propertyName);

            if (null == oldPropertyValue && null == newPropertyValue) {
                continue;
            }
            if ("".equals(oldPropertyValue) && "".equals(newPropertyValue)) {
                continue;
            }
            if (null == oldPropertyValue) {
                oldPropertyValue = "";
            }
            if (null == newPropertyValue) {
                newPropertyValue = "";
            }

            if (oldPropertyValue.equals(newPropertyValue)) {
                continue;
            }
            compares.append("[字段注释: ").append(entity.getValue()).append("]").append("原属性值\"");
            if (StringUtils.isEmpty(oldPropertyValue + "")) {
                oldPropertyValue = " ";
            }
            compares.append(oldPropertyValue).append("\"现属性值\"");
            if (StringUtils.isEmpty(newPropertyValue + "")) {
                newPropertyValue = " ";
            }
            compares.append(newPropertyValue).append("\";\n");
        }
        return compares.toString();
    }
}