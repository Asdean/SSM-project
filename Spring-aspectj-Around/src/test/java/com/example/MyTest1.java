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

        // System.out.println(service.getClass().getName());
        String ret = service.doFirst("lisi");
        System.out.println(ret);
    }

}
