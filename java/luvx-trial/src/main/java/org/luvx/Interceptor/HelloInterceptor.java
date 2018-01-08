package org.luvx.Interceptor;

import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

/**
 * 拦截器
 */
public class HelloInterceptor extends AbstractInterceptor {

    @Override
    public String intercept(ActionInvocation invocation) throws Exception {
        System.out.println("Before Action...");
        String result = invocation.invoke();
        System.out.println("After Action...");
        return result;
    }
}
