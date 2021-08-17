package com.example.example05;

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
     *             支持byName，byType。默认是byType。
     *
     *      属性：required ：boolean类型的属性， 默认true
     *        true：spring在启动的时候，创建容器对象时候，会检查引用类型是否赋值成功。
     *              如果赋值失败， 终止程序执行，并报错。
     *         false：引用类型赋值失败，程序正常执行，不报错。引用类型的值是null
     *
     *
     *      位置：1)在属性定义的上面，无需set方法，推荐使用
     *             2）在set方法的上面
     */
    // 使用ByName
    @Autowired(required = false)
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
