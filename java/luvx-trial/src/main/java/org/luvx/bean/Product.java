package org.luvx.bean;

import java.util.HashSet;
import java.util.Set;

public class Product {

    private Integer productid;
    private String productname;

    private Set<Orders> orders=new HashSet<Orders>();

    public Integer getProductid() {
        return productid;
    }

    public void setProductid(Integer productid) {
        this.productid = productid;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname;
    }

    public Set<Orders> getOrders() {
        return orders;
    }

    public void setOrders(Set<Orders> orders) {
        this.orders = orders;
    }
}
