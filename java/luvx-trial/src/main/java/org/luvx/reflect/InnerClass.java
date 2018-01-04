package org.luvx.reflect;

public class InnerClass {

    private String astrofInner = "a000";

    public class Apple {
        private String astrInApple = "aaa";
    }

    public class Bear {
        public String astroInBear = "bbb";
    }

    public static class Peach {
        private static String astrInPeach = "ccc1";
        public static String bstrInPeach = "ccc2";
    }

    public static class Watermelon {
        public String name = "old Watermelon";
        private String name2 = "small Watermelon";
        private static String astrInWatermelon = "ccc1";
        public static String bstrInWatermelon = "ccc2";
    }


    private Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("no name");
        }
    };

    /**
     * 静态方法
     *
     * @param a
     * @param b
     * @return
     */
    public static int mul1(int a, int b) {
        return b * a;
    }

    /**
     * 私有
     *
     * @param a
     * @param b
     * @return
     */
    private int mul(int a, int b) {
        return a * b;
    }

    /**
     * 公有
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        return a + b;
    }

    /**
     * 参数为包装类
     *
     * @param a
     * @param b
     * @return
     */
    public Integer add(Integer a, Integer b) {
        return a + b;
    }


}
