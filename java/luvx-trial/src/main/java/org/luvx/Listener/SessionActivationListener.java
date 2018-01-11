package org.luvx.Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

/**
 * 钝化和活化
 */
@WebListener
public class SessionActivationListener implements HttpSessionActivationListener {
    @Override
    public void sessionWillPassivate(HttpSessionEvent hse) {
        System.out.println("LuVx:HttpSessionActivationListener:Passivate Attribute:" + hse.getName());
    }

    @Override
    public void sessionDidActivate(HttpSessionEvent hse) {
        System.out.println("LuVx:HttpSessionActivationListener:Activate Attribute:" + hse.getName());
    }
}
