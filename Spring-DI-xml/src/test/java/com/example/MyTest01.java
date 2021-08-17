package com.example;

import com.example.example01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest01 {
    @Test
    public void Test01() {
        String config = "example01/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);

        Date time = (Date) ctx.getBean("date");
        System.out.println(time);
    }
}
