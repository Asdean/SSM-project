package com.example;

import com.example.service.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest1 {
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService service = (SomeService) ctx.getBean("someService");

        // 没有加入代理的处理：
        //  1）目标方法执行时，没有切面功能的。
        //  2) service对象没有被改变
        /*System.out.println(service.getClass().getName());
        service.doSome("lisi", 20);*/
    }

    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService service = (SomeService) ctx.getBean("someService");
        // 加入代理的处理：
        //  1）目标方法执行时，有切面功能的。
        //  2) service对象是改变后的 代理对象 com.sun.proxy.$Proxy10
        System.out.println(service.getClass().getName());
        service.doSome("lisi", 20);
    }

    @Test
    public void test03() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        SomeService service = (SomeService) ctx.getBean("someService");

        System.out.println(service.getClass().getName());
        service.doOther();
    }
}
