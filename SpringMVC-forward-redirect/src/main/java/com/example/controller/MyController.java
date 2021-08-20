package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    /**
     *  控制器方法返回是ModelAndView实现转发forward
     *  语法： mv.setViewName("forward:视图完整路径")
     *
     *  forward特点：不和视图解析器一同工作的，就当项目中没有视图解析器
     */
    @RequestMapping(value = "/doForward.do")
    public ModelAndView doForward() {
        System.out.println("执行了doForward()方法");
        ModelAndView mv = new ModelAndView();


        mv.addObject("msg", "处理了doForward.do请求");
        mv.addObject("func", "执行了doForward()方法");

        // 显示指示转发路径，用于向不在视图解析器路径下的页面转发
        // 例如mv.setViewName("forward:/show.jsp");
        mv.setViewName("forward:/WEB-INF/view/show.jsp");

        return mv;
    }

    /**
     * 当控制器方法返回ModelAndView实现重定向
     * 语法： mv.setViewName("redirect:视图完整路径)
     * redirect特点：不和视图解析器一同工作，就当项目中没有视图解析器
     *
     * 框架提供的重定向的功能
     * 1. 框架可以实现两次请求之间的数据传递， 把第一个请求中的Model里面
     *    简单类型的数据，转为字符串，附加到目标页面的后面，做get参数传递。
     *    可以在目标页面中获取参数值使用。
     *
     * 2.在目标页面中，可以使用 ${param.参数名} 获取参数的值
     */
    @RequestMapping("/doRedirect.do")
    public ModelAndView doRedirect(String name, Integer age){
        System.out.println("doRedirect ,name="+name+",age="+age);
        ModelAndView mv  = new ModelAndView();
        mv.addObject("myname", name);
        mv.addObject("myage", age);

        // http://localhost:8080/SpringMVC_forward_redirect/other.jsp?myname=lisi&myage=22
        // 重定向页面作用域发生改变，不能直接在重定向页面获取myname,myage
        mv.setViewName("redirect:/other.jsp");


        //重定向不能访问/WEB-INF
        //mv.setViewName("redirect:/WEB-INF/view/show.jsp");
        return mv;
    }
}
