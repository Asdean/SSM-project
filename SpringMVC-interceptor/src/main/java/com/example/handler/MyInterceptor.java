package com.example.handler;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 拦截器，拦截前端控制器向Controller发送的请求
 */
public class MyInterceptor implements HandlerInterceptor {
    /**
     * preHandle: 预先处理请求的方法。
     *
     * @param request
     * @param response
     * @param handler 被拦截的控制器对象（MyController）
     * @return boolean
     *  true: 请求是正确的，可以被controller处理的。
     *      preHandle, postHandle, afterCompletion执行, 前端有数据, 对Controller的请求方法执行
     *  false: 请求不能被处理，控制器方法不会执行。请求到此截止。
     *      只执行preHandle, 前端无数据, Controller的方法不执行
     * @throws Exception
     *
     * 特点：
     *  1. 预处理方法他的执行时间： 在控制器方法之前先执行的。
     *  2. 可以对请求做处理， 可以做登录的检查， 权限的判断， 统计数据等等。
     *  3. 决定请求是否执行。
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
        System.out.println("----MyInterceptor拦截器的preHandle方法----");

        return true;
        // request..getRequestDispatcher("/tips.jsp").forward(request, response);
        // return false;
    }

    /**
     * postHandle: 后处理方法
     *
     * @param request
     * @param response
     * @param handler 被拦截的控制器对象（MyController）
     * @param modelAndView 控制器方法的返回值（请求的执行结果）
     * @throws Exception
     *
     * 特点：
     *  1.在控制器方法之后执行的。
     *  2.能获取到控制器方法的执行结果。可以修改原来的执行结果。
     *  可以修改数据，也可以修改视图.
     *  3.可以做对请求的二次处理。
     */
    @Override
    public void postHandle(HttpServletRequest request,
                           HttpServletResponse response,
                           Object handler,
                           ModelAndView modelAndView) throws Exception {
        System.out.println("----MyInterceptor拦截器的postHandle方法----");
        // 对请求做二次处理
        if (modelAndView != null) {
            // 修改数据
            modelAndView.addObject("myDate", new Date());

            // 修改视图
            modelAndView.setViewName("other");
        }
    }

    /**
     * afterCompletion: 最后执行的方法
     *
     * @param request
     * @param response
     * @param handler 被拦截的控制器对象（MyController）
     * @param ex 异常对象
     * @throws Exception
     *
     * 特点：
     *  1.在请求处理完成后执行的，
     *  请求处理完成的标志是 视图处理完成，对视图执行forward操作后。
     *  2.可以做程序最后要做的工作， 释放内存， 清理临时变量。
     *  3.方法的执行条件：
     *  1）当前的拦截器他的preHandle()方法必须执行。
     *  2）preHandle()必须返回true。
     */
    @Override
    public void afterCompletion(HttpServletRequest request,
                                HttpServletResponse response,
                                Object handler,
                                Exception ex) throws Exception {
        System.out.println("----MyInterceptor拦截器的afterCompletion方法----");
        // 获取临时数据
        HttpSession session = request.getSession();
        String attr = (String) session.getAttribute("attr");
        System.out.println("attr=" + attr);

        // 删除数据
        session.removeAttribute("attr");

        // 再次获取临时数据
        attr = (String) session.getAttribute("attr");
        System.out.println("再次获取attr=" + attr);
    }
}
