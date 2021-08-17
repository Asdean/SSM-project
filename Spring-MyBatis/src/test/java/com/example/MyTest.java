package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    @Test
    public void test01() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        String[] names = ctx.getBeanDefinitionNames();

        for (String name : names) {
            System.out.println("对象名称:" + name + "\t对象类型" + ctx.getBean(name));
        }
    }

    @Test
    public void test02() {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");

        StudentDao dao = (StudentDao) ctx.getBean("studentDao");

        Student student = new Student();
        student.setName("李四");
        student.setAge(20);
        dao.insertStudent(student);
    }
}