package com.example.controller;

import com.example.entity.Student;
import com.example.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService service;

    @RequestMapping("/addStudent.do")
    public ModelAndView addStudent(Student student) {
        ModelAndView mv  = new ModelAndView();

        //调用service，处理业务逻辑，把处理结果返回给用户
        int rows  = service.addStudent(student);

        String msg="注册失败!";
        if(rows > 0 ) {
            //注册成功， 给用户成功的数据和视图
            msg = "注册成功!";
        }

        mv.addObject("msg", student.getName()+","+msg);
        mv.setViewName("result");

        return mv;
    }

    @RequestMapping("/queryStudent.do")
    @ResponseBody
    public List<Student> queryStudents() {
        List<Student> students = service.queryStudents();
        return students;
    }
}
