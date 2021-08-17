package com.example;

import static org.junit.Assert.assertTrue;

import com.example.dao.UserDao;
import com.example.service.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Unit test for simple App.
 */
public class AppTest 
{

    @Test
    public void test01(){
        String config = "applicationContext.xml";

        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        UserService service = (UserService) ctx.getBean("userService");

//        SysUser user = new SysUser();
//        user.setName("lisi");
//        user.setAge(20);
//        serivce.addUser(user);


        UserDao dao  = (UserDao) ctx.getBean("mysqlDao");
        dao.insertUser(null);
    }
}
