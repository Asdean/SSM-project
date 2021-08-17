package com.example;

import com.example.service.NumberService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        NumberService service = (NumberService) ctx.getBean("service");

        Integer nums = service.addNumber(1, -2, 3);
        System.out.println(nums);
    }
}
