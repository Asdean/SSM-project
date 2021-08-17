package com.example.example07;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

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
     * @Resource: 来自jdk中，给引用类型赋值的，支持byName,byType.默认是byName
     *             spring支持这个注解的使用。
     *      位置：1）在属性定义的上面，无需set方法，推荐使用
     *            2）在set方法的上面
     *
     *  说明，使用jdk1.8带有@Resource注解， 高于jdk1.8没有这个@Resource,
     *  需要加入一个依赖。
     *  <dependency>
     *     <groupId>javax.annotation</groupId>
     *     <artifactId>javax.annotation-api</artifactId>
     *     <version>1.3.2</version>
     *  </dependency>
     *
     *
     *  @Resource只使用byName赋值
     *  使用注解属性name="bean的id"
     */
    // 只使用 byName自动注入
    @Resource(name="school")
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
