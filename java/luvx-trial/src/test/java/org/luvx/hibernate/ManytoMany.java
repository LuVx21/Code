package org.luvx.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.luvx.bean.Orders;
import org.luvx.bean.Product;
import org.luvx.utils.HibernateUtils;

public class ManytoMany {
/*

    // sessionFactory一被创建,表结构随之被创建

    @Test
    public void getsessionTest() {
        HibernateUtils.openSession();
    }

    @Test
    public void run01() {
        Session session = HibernateUtils.openSession();
        Transaction ts = session.beginTransaction();

        Orders orders01 = new Orders();
        Orders orders02 = new Orders();


        Product product01 = new Product();
        Product product02 = new Product();

        product01.setProductname("Phone");
        product02.setProductname("Mac Pro");

        orders01.getProducts().add(product01);
        orders01.getProducts().add(product02);

        orders02.getProducts().add(product02);
        session.save(orders01);
        session.save(orders02);

        ts.commit();
    }
*/
}
