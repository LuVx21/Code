package org.luvx.bean;

import java.util.Date;

/**
 * 订单
 */
public class Orders {

    private Integer orderid;
    // 不要实例化
    private User user;

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
}
