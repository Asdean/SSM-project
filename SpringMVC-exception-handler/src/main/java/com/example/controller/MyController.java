package com.example.controller;

import com.example.exception.AgeException;
import com.example.exception.MyUserException;
import com.example.exception.NameException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyController {
    @RequestMapping(value = "/some.do")
    public ModelAndView doSome(String name, Integer age) throws MyUserException  {
        System.out.println("执行了doSome()方法");
        ModelAndView mv = new ModelAndView();

        if (!"zs".equals(name)) {
            throw new NameException("名字不正确");
        }

        if (age == null || age.intValue() >= 80) {
            throw new AgeException("年龄太大了");
        }

        mv.addObject("myname", name);
        mv.addObject("myage", age);

        mv.setViewName("show");

        return mv;
    }
}
