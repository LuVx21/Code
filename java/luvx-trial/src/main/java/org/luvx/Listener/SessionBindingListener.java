package org.luvx.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

/**
 * 绑定和解绑
 * jsp:
 * <%session.setAttribute("p", new Person(1,"LuVx")); %>
 * ${p2.name }
 * <%session.removeAttribute("p");%>
 */
@WebListener
public class SessionBindingListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {

    }
}
