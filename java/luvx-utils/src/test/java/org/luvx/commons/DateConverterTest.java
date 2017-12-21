package org.luvx.commons;

import org.junit.Test;

import java.util.Date;

public class DateConverterTest {

    @Test
    public void convertTest() {
        String astr = "2017-12-21";
        DateConverter aconverter = new DateConverter();
        Class clazz = null;
        Date adate = (Date) aconverter.convert(clazz, astr);
        System.out.println(adate);
    }
}

