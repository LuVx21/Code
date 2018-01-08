package org.luvx.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * 拦截对/helloservlet的请求
 */
@WebFilter(filterName = "HelloFilter", urlPatterns = "/helloservlet")
public class HelloFilter implements Filter {
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        System.out.println("过滤器 hello filter 收到了请求....");
        chain.doFilter(req, resp);
        System.out.println("过滤器 hello filte 做出了响应....");
    }

    public void destroy() {
    }
}
