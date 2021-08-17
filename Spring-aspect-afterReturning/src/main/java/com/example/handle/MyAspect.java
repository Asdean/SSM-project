package com.example.handle;

import org.aspectj.lang.annotation.AfterReturning;
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
       后置通知方法的定义
       1）方法是public
       2）方法是void
       3）方法名称自定义
       4）方法有参数，推荐使用Object类型。
     */

    /**
     * @AfterReturning:后置通知
     *    属性：value 切入点表达式
     *          returning 自定义的变量，表示目标方法的返回值的。
     *                    自定义变量名称必须和通知方法的形参名一样
     *    位置：在方法的上面
     *
     * 特点：
     *  1.在目标方法之后，执行的。
     *  2.能获取到目标方法的执行结果。
     *  3.不会影响目标方法的执行
     *
     * 方法的参数：
     *   Object res： 表示目标方法的返回值，使用res接收doOther的调用结果。
     *   Object res= doOther();
     *
     *  后置通知的执行顺序
     *  Object res = SomeServiceImpl.doOther(..); Student
     *
     *  myAfterReturning(res);
     */
    @AfterReturning(value = "execution(* *..SomeServiceImpl.do*(..))", returning = "res")
    public void myAfterReturning(Object res){
        System.out.println("后置通知，在目标方法之后拿到返回值:" + res);

        if (res != null) {
            res = "Hello";
        }

        // 根据不同返回值增强功能
        /*if ("abc".equals(res)) {
            System.out.println("根据不同返回值增强功能1");
        } else if ("add".equals(res)) {
            System.out.println("根据不同返回值增强功能2");
        }*/
    }
}
