package com.example.example02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 简单类型属性赋值:@Value
 * 属性：value 简单类型属性值
 *  位置：1）在属性定义的上面，无需set方法，推荐使用
 *       2）在set方法的上面
 */

@Component("student")
public class Student {
    @Value("李四")
    // @Value("${myName}")
    private String name;
    private int age;

    public Student() {
        System.out.println("Student无参数构造方法");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void setName(String name) {
        System.out.println("setName==" + name);
        this.name = name;
    }

    @Value("20")
    // @Value("${myAge}")
    public void setAge(int age) {
        System.out.println("setAge==" + age);
        this.age = age;
    }
}
