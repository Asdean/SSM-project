package com.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome() {
        System.out.println("执行了doSome方法");

        ModelAndView mv = new ModelAndView();

        mv.setViewName("show");

        return mv;
    }

    // 使用完整路径
    @RequestMapping(value = "/test/some.do")
    public ModelAndView doSome1() {
        System.out.println("执行了doSome1方法");

        ModelAndView mv = new ModelAndView();

        mv.setViewName("/index.jsp");

        return mv;
    }
}
