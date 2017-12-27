package org.luvx.bean;

import java.util.HashSet;
import java.util.Set;

/**
 * 订单
 */
public class Orders {

    private Integer orderid;
    // 不要实例化
    private User user;

    private Set<Product> products = new HashSet<Product>();

    public Integer getOrderid() {
        return orderid;
    }

    public void setOrderid(Integer orderid) {
        this.orderid = orderid;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
