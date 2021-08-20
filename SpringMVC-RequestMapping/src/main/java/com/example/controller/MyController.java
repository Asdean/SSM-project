package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller： 创建控制器（处理器）对象
 *  控制器：叫做后端控制器（back controller）,自定义的类处理请求的。
 *  位置：在类的上面，表示创建此类的对象，对象放在springmvc的容器中。
 *
 * @RequestMapping
 *  属性 value ：表示所有请求地址的公共前缀，相当于是模块名称。
 *  位置：在类的上面
 */
@Controller
// @RequestMapping("/student")
public class MyController {
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
    // 前端使用post方式访问时，报错请求方式不一样，错误码是405，请求方式不支持
    @RequestMapping(value = "/some.do", method = RequestMethod.GET)
    public ModelAndView doSome() {
        System.out.println("执行了doSome()方法");
        ModelAndView mv = new ModelAndView();

        // 添加数据
        mv.addObject("msg", "处理了some.do请求");
        mv.addObject("func", "执行了doSome()方法");

        // 指定视图，setViewName("视图的完整路径")
        mv.setViewName("show");

        // 返回结果
        return mv;
    }

    @RequestMapping(value = "/other.do", method = RequestMethod.POST)
    public ModelAndView doOther(){
        System.out.println("执行了MyController的doOther方法");
        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理了other.do请求");
        mv.addObject("func", "执行了doOther方法");
        mv.setViewName("other");
        //返回结果
        return mv;
    }

    @RequestMapping(value = "/first.do")
    public ModelAndView doFirst(){
        System.out.println("执行了MyController的doOther方法");
        ModelAndView mv  = new ModelAndView();
        //添加数据
        mv.addObject("msg", "处理first.do请求");
        mv.addObject("func", "执行了doFirst方法");
        mv.setViewName("other");
        //返回结果
        return mv;
    }
}
