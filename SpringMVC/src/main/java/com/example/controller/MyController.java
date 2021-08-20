package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller： 创建控制器（处理器）对象
 *  控制器：叫做后端控制器（back controller）,自定义的类处理请求的。
 *  位置：在类的上面，表示创建此类的对象，对象放在springmvc的容器中。
 */
@Controller
public class MyController {
    // 定义方法，处理请求。public void doGet(){}

    /**
     * springmvc框架，使用控制器类中的方法，处理请求。
     * 方法的特点：
     *  1. 方法的形参，表示请求中的参数
     *  2. 方法的返回值，表示本次请求的处理结果
     */

    /**
     * @RequestMapping: 请求映射
     *  属性：value 请求中的uri地址，唯一值，以"/"开头。
     *  位置：1.在方法的上面（必须的） 2.在类定义的上面（可选）
     *  作用：把指定的请求，交给指定的方法处理，等同于url-pattern
     *
     * 返回值ModelAndView:表示本次请求的处理结果（数据和视图）
     *  Model：表示数据
     *  View：表示视图
     */
    @RequestMapping({"/some.do", "/first.do"})
    public ModelAndView doSome() { // doGet()
        // 使用这个方法处理请求。能够处理请求的方法叫做控制器方法
        // 调用service对象，处理请求，返回数据
        System.out.println("执行了doSome()方法");
        ModelAndView mv = new ModelAndView();

        // 添加数据
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("func", "执行了doSome()方法");

        // 指定视图，setViewName("视图的完整路径")
        // mv.setViewName("/show.jsp");
        // mv.setViewName("/WEB-INF/view/show.jsp");
        // mv.setViewName("/WEB-INF/view/other.jsp");

        // 使用视图解析器
        // 当配置了视图解析器，使用文件名称作为视图名使用，叫做视图逻辑名称
        // 使用了逻辑名称，框架使用配置文件中视图解析器的前缀和后缀，拼接为完整视图路径
        // /WEB-INF/view/ + show + .jsp
        mv.setViewName("show");

        // 返回结果
        return mv;
    }

    @RequestMapping(value ={ "/other.do", "/test/second.do"})
    public ModelAndView doOther(){  // doGet()
        System.out.println("执行了MyController的doOther方法");
        // 使用这个方法处理请求。 能处理请求的方法叫做控制器方法
        // 调用service对象，处理请求，返回数据
        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了other.do请求");
        mv.addObject("func", "执行了doOther方法");
        mv.setViewName("other");
        //返回结果
        return mv;

    }
}
