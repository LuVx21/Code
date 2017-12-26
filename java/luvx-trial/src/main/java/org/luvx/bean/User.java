package org.luvx.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 用户
 */
public class User {

    private Integer userid;
    private String username;
    private String password;
    // 需要实例化
    private Set<Order> orders = new HashSet<Order>();


    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return String.valueOf(userid) + "-" + username + "-" + password;
    }
}
