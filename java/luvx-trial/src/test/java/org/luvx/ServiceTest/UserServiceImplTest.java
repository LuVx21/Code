package org.luvx.ServiceTest;

import org.junit.Test;
import org.luvx.ServiceImpl.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserServiceImplTest {

    @Test
    public void run01() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServiceImpl usi = (UserServiceImpl) ac.getBean("userService");
        usi.sayHello();
    }
}
