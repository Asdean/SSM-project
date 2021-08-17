package com.example.example04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component("student")
public class Student {
    @Value("李四")
    // @Value("${myName}")
    private String name;
    @Value("22")
    private int age;

    public Student() {
        System.out.println("Student无参数构造方法");
    }

    /**
     * 引用类型
     * @Autowired: spring框架提供的，给引用类型赋值的，使用自动注入原理。
     *             支持byName，byType。默认是byType.
     *        位置：1)在属性定义的上面，无需set方法，推荐使用
     *             2）在set方法的上面
     */
    // 使用ByName
    @Autowired
    @Qualifier("school")
    private School school;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
