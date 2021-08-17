package com.example;

import com.example.services.OtherService;
import com.example.services.SomeService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

public class MyTest {
    @Test
    public void testDoSome() {
        // 1.指定spring配置文件: 从类路径（classpath）之下开始的路径
        String config = "beans.xml";
        // 2.创建容器对象， ApplicationContext 表示spring容器对象。 通过ctx获取某个java对象
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // 3.从容器中获取指定名称的对象， 使用getBean(“id”)
        SomeService service = (SomeService) ctx.getBean("someService");
        // 4.调用对象的方法，接口中的方法
        service.doSome();
    }

    /**
     * 默认是调用类的无参数构造方法。
     * 如果声明有参数构造方法而没声明无参数构造方法，报错。
     */
    @Test
    public void test01() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        SomeService service = ctx.getBean(SomeService.class);
        service.doSome();
    }

    /**
     *　spring是在什么时候创建的对象？
     * 创建spring容器对象的时候，会读取配置文件，创建文件中声明的java对象。
     *
     * 优点：获取对象的速度快，因为对象已经创建好了
     *
     * 缺点：占用内存
     */
    @Test
    public void test02(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // SomeService service  = (SomeService) ctx.getBean("someService");
        // service.doSome();
    }

    /**
     * 在创建容器（ApplicationContext）对象时，会把配置文件中的所有对象都创建出来（spring的默认规则）
     */
    @Test
    public void test03(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        // SomeService service  = (SomeService) ctx.getBean("someService");
        // service.doSome();
    }

    /**
     * 获取容器中对象的信息
     */
    @Test
    public void test04() {
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);

        //获取容器中定义对象的数量
        int nums = ctx.getBeanDefinitionCount();
        System.out.println("容器中定义对象的数量：" + nums);

        //获取容器中定义的对象名称
        String names[] = ctx.getBeanDefinitionNames();
        for(String name : names) {
            System.out.println("容器中对象的名称：" + name);
        }

        //new java.util.Date();
    }

    /**
     * 让spring创建非自定义类的对象
     * 有class就能让spring创建对象
     */
    @Test
    public void test05(){
        String config = "beans.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        Date date = (Date) ctx.getBean("date");
        System.out.println("date："+date);

        OtherService service = (OtherService) ctx.getBean("otherService");
        service.doOther();
    }
}
