package com.example.handle;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class MyAspect {
    @Pointcut("execution(* *..NumberServiceImpl.*(..))")
    private void myPointcut() {}

    @Around("myPointcut()")
    public Object myAround(ProceedingJoinPoint joinPoint) throws Throwable {
        // true表示参数正确的
        boolean isAll = true;

        // 获取执行addNumber方法时的实参
        Object[] args = joinPoint.getArgs();
        for (Object arg : args) {
            if(arg == null){
                // 参数是null，不正确。
                isAll = false;
                break;
            } else {
                // 参数不为null
                Integer temp = (Integer) arg;
                if (temp.intValue() <= 0) {
                    isAll = false;
                    break;
                }
            }
        }

        // 根据参数检查的结果，决定是否执行目标方法
        Object res = null;
        if( isAll ){
            // 调用目标方法
            res = joinPoint.proceed();
        } else {
            // 参数检查不正确
            res  = -1;
        }
        return res;
    }
}
