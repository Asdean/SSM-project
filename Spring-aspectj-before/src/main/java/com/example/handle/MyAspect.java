package com.example.handle;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect 切面类的注解
 */
@Aspect
public class MyAspect {
    //定义方法，表示切面的具体功能
    /*
       前置通知方法的定义
       1）方法是public
       2）方法是void
       3）方法名称自定义
       4）方法可以有参数，如果有是JoinPoint
          也可以没有
     */

    /**
     * @Before：前置通知
     * 属性：value 切入点表达式，表示切面的执行位置。
     * 在这个方法时，会同时执行切面的功能
     * 位置：在方法的上面
     *
     * 特点：
     * 1）执行时间：在目标方法之前先执行的。
     * 2）不会影响目标方法的执行。
     * 3）不会修改目标方法的执行结果。
     */
    /*@Before(value = "execution(public void com.example.service.impl.SomeServiceImpl.doSome(String, Integer) )")
    public void myBefore(){
        // 切面的代码。
        System.out.println("前置通知，切面的功能，在目标方法之前先执行:" + new Date());
        System.out.println("\r\n");
    }*/

    /*@Before(value = "execution(* *..SomeServiceImpl.do*(..) )")
    public void myBefore(){
        System.out.println("前置通知，切面的功能，在目标方法之前先执行:" + new Date());
    }*/

    /**
     * 切面类中的通知方法，可以有参数
     * JoinPoint必须是他。
     *
     * JoinPoint: 表示正在执行的业务方法。 相当于反射中 Method
     *   使用要求：必须是参数列表的第一个
     *   作用：获取方法执行时的信息，例如方法名称， 方法的参数集合
     */
    @Before(value = "execution(* *..SomeServiceImpl.do*(..) )")
    public void myBefore(JoinPoint joinPoint){
        // 获取方法定义
        System.out.println("前置通知中获取方法定义:" + joinPoint.getSignature());
        // 获取方法名称
        System.out.println("前置通知中获取方法名称:" + joinPoint.getSignature().getName());
        // 获取方法参数
        Object[] args = joinPoint.getArgs();
        for (Object obj : args) {
            System.out.println("方法参数:" + obj);
        }

        String methodName = joinPoint.getSignature().getName();
        if ("doSome".equals(methodName)) {
            System.out.println("前置通知，doSome():" + new Date());
        } else if ("doOther".equals(methodName)) {
            System.out.println("前置通知，doOther():" + new Date());
        }
    }

}
