package org.luvx.commons;

import org.apache.commons.beanutils.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 把String转换成java.util.Date的类型转换器
 */
public class DateConverter implements Converter {

    @SuppressWarnings("rawtypes")
    @Override
    public Object convert(Class type, Object value) {
        //如果要转换成值为null，那么直接返回null
        if (value == null)
            return null;
        //如果要转换的值不是String
        if (!(value instanceof String)) {
            return value;
        }
        String val = (String) value;

        // 使用SimpleDateFormat进行转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return sdf.parse(val);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
