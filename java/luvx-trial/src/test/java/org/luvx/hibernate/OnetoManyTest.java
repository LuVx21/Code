package org.luvx.hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;
import org.luvx.bean.Order;
import org.luvx.bean.User;
import org.luvx.utils.HibernateUtils;
import org.hibernate.cfg.Configuration;


/**
 * 一对多测试
 */
public class OnetoManyTest {
///*
    @Test
    public void run01() {

        Session session = new Configuration().configure().buildSessionFactory().openSession();

        Transaction ts = session.beginTransaction();
        User user = new User();
        Order order01 = new Order();
        Order order02 = new Order();

        user.getOrders().add(order01);
        user.getOrders().add(order02);
        session.save(user);


        ts.commit();
        session.close();
    }
//*/
}
