package me.ren.Java8.Lambda;

import org.junit.Test;

public class Attri {

    static int outerStaticNum = 0;
    int outerNum = 0;

    @Test
    public void testScopes() {
        int aa = 233;
        // 访问局部变量
        FuncInterface<Integer, String> stringConverter0 = (from) -> {

            return String.valueOf(from + aa);
        };
        // 访问成员变量
        FuncInterface<Integer, String> stringConverter1 = (from) -> {
            outerNum = 23;
            return String.valueOf(from);
        };
        // 访问静态变量
        FuncInterface<Integer, String> stringConverter2 = (from) -> {
            outerStaticNum = 72;
            return String.valueOf(from);
        };
        System.out.println(stringConverter0.convert(1));
        stringConverter1.convert(23);
        stringConverter2.convert(24);
        System.out.println(outerNum);
        System.out.println(outerStaticNum);
    }
}
