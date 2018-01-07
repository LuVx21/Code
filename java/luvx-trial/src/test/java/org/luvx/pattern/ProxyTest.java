package org.luvx.pattern;

import org.junit.Test;
import org.luvx.pattern.Proxy.PrinterProxy;

public class ProxyTest {
    /**
     * 标准的使用结构
     */
    @Test
    public void run00() {
        new PrinterProxy().printlog();
    }

    /**
     * getPrinterProxy设置为public
     * 可以动态设置增强的方法
     */
    @Test
    public void run01() {
        String methodName = "printlog";
        new PrinterProxy().getPrinterProxy(methodName).printlog();
    }


}
