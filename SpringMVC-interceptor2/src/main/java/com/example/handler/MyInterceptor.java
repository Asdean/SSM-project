package com.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

public class MyInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("----MyInterceptor1拦截器的preHandle方法----");

        return true;
        // return false;
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("----MyInterceptor1拦截器的postHandle方法----");
        // 对请求做二次处理
        if (modelAndView != null) {
            // 修改数据
            modelAndView.addObject("myDate", new Date());

            // 修改视图
            modelAndView.setViewName("other");
        }
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("----MyInterceptor1拦截器的afterCompletion方法----");
    }
}
