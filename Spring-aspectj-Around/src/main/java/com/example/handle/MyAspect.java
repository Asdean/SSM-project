package com.example.handle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.util.Date;

/**
 * @Aspect 切面类的注解
 */
@Aspect
public class MyAspect {
     /*
       环绕置通知方法的定义
       1）方法是public
       2）方法是必须有返回值， 推荐使用Object类型
       3）方法名称自定义
       4）方法必须有ProceedingJoinPoint参数，
     */

    /**
     * @Around：环绕通知
     *    属性：value 切入点表达式
     *    位置：在方法定义的上面
     *
     * 返回值：Object ，表示调用目标方法希望得到执行结果（不一定是目标方法自己的返回值）
     * 参数：  ProceedingJoinPoint, 相当于反射中 Method。
     *        作用：执行目标方法的，等于Method.invoke()
     *
     *        public interface ProceedingJoinPoint extends JoinPoint {}
     *
     * 特点：
     *  1.在目标方法的前和后都能增强功能
     *  2.控制目标方法是否执行
     *  3.修改目标方法的执行结果。
     */
    @Around("execution(* *..SomeServiceImpl.doFirst(..))")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取方法执行时的参数值
        String name = "";
        Object args [] = joinPoint.getArgs();
        if( args != null && args.length > 0){
            Object arg = args[0];
            if(arg != null){
                name = (String) arg;
            }
        }

        Object methodReturn = null;

        System.out.println("执行环绕通知，在目标方法之前" + new Date());
        // 执行目标方法  ProceedingJoinPoint，表示doFirst

        if("lisi".equals(name)){
            // method.invoke(),表示执行doFirst()方法本身
            methodReturn = joinPoint.proceed();
        }

        if( methodReturn != null){
            methodReturn = "环绕通知中，修改目标方法原来的执行结果";
        }

        System.out.println("环绕通知，在目标方法之后，增加功能");

        // return "HelloAround,不是目标方法的执行结果";
        // 返回目标方法执行结果。没有修改的。
        return methodReturn;
    }
}
