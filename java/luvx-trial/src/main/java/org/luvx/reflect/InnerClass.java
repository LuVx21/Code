package org.luvx.reflect;

public class InnerClass {

    private String astrofInner = "a000";

    public class A {
        private String astrofA = "aaa";
    }

    public class B {
        private String astrofB = "bbb";
    }

    public static class C {
        private static String astrofC = "ccc1";
        public String bstrofC = "ccc2";
    }


    private Runnable r = new Runnable() {
        @Override
        public void run() {
            System.out.println("no name");
        }
    };


}
