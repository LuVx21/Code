package org.luvx.ServiceImpl;

import org.luvx.Daoimpl.UserDaoImpl;
import org.luvx.Service.UserService;

public class UserServiceImpl implements UserService {

    private String name;
    private UserDaoImpl userDao;

    public void setUserDao(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void sayHello() {
        System.out.println("Hello Spring!! " + name);
        userDao.save();
    }

    public void init() {
        System.out.println("初始化...");
    }

    public void destory() {
        System.out.println("销毁...");
    }
}
