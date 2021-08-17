package com.example.handle;

import org.aspectj.lang.annotation.*;

/**
 * @Aspect 切面类的注解
 */
@Aspect
public class MyAspect {
    @Before(value = "mypt()")
    public void myBefore(){
        System.out.println("前置通知，在目标方法之前先执行的");
    }

    @After(value = "mypt()")
    public void myAfter(){
        System.out.println("最终通知，总是会被执行的");
    }


    /**
     * @Pointcut: 定义和管理切入点，不是通知注解。
     *     属性： value 切入点表达式
     *     位置： 在一个自定义方法的上面， 这个方法看做是切入点表达式的别名。
     *           其他的通知注解中，可以使用方法名称，就表示使用这个切入点表达式了
     */
    @Pointcut("execution(* *..SomeServiceImpl.doThird(..))")
    // 可以存在多个不同的
    private void mypt(){
        //无需代码
    }
}
