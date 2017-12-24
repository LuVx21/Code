package org.luvx.hibernate;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;
import org.luvx.bean.User;

import java.util.List;

public class HibernateTest {
/*
    @Test
    public void insertTest() {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();

        User user = new User();
        user.setUsername("aaa");
        user.setPassword("abcdefg");
        session.save(user);

        trans.commit();

        session.close();
    }


    @Test
    public void selectTest() {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // 主键来查询
        User user1 = session.get(User.class, 1);
        System.out.println(user1);

        // 创建查询的接口
        Query query = session.createQuery("from User");

        List<User> list = query.list();
        for (User user : list) {
            System.out.println(user);
        }
        session.close();
    }


    @Test
    public void updateTest() {
        Configuration conf = new Configuration().configure();
        SessionFactory sessionFactory = conf.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction trans = session.beginTransaction();

        User user = session.get(User.class, 1);
        System.out.println(user);
        user.setPassword("123456");
        user = session.get(User.class, 1);
        System.out.println(user);

        trans.commit();
        session.close();
    }
*/
}
