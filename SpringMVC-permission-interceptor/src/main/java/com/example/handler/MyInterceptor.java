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
        System.out.println("----MyInterceptor拦截器的preHandle方法----");

        String username = "";
        //获取登录的账号信息
        Object attr = request.getSession().getAttribute("username");
        if(attr != null){
            username = (String) attr;
        }

        //判断账号
        if("zhangsan".equals(username)) {
            return true;
        } else {
            request.getRequestDispatcher("/tips.jsp").forward(request, response);
            return false;
        }
    }

    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("----MyInterceptor拦截器的postHandle方法----");
    }


    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("----MyInterceptor1拦截器的afterCompletion方法----");
    }
}
