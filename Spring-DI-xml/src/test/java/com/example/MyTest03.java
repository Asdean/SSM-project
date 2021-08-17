package com.example;

import com.example.example03.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class MyTest03 {
    @Test
    public void Test01() {
        String config = "example03/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }

    @Test
    public void Test02() {
        String config = "example03/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student2");
        System.out.println(student);
    }

    @Test
    public void Test03() {
        String config = "example03/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Student student = (Student) ctx.getBean("student3");
        System.out.println(student);
    }

    @Test
    public void Test04() {
        String config = "example03/applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        File file = (File) ctx.getBean("file");
        System.out.println("fileName = " + file);
    }
}
