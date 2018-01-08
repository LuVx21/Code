package org.luvx.Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * 监听ServletContext的创建,销毁
 */
@WebListener()
public class ContextListener implements ServletContextListener {

    public ContextListener() {
    }

    /**
     * 创建操作
     *
     * @param sce
     */
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("servletcontext创建了");
    }

    /**
     * 销毁操作
     *
     * @param sce
     */
    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servletcontext销毁了.");
    }
}
