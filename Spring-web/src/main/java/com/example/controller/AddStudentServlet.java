package com.example.controller;

import com.example.domain.Student;
import com.example.service.StudentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddStudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String strName = request.getParameter("name");
        String strAge = request.getParameter("age");

        //调用service
        //使用spring提供的工具方法，获取容器对象
        WebApplicationContext ctx = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getServletContext());


        StudentService service = (StudentService) ctx.getBean("studentService");
        Student student = new Student();
        student.setStuname(strName);
        student.setStuage(Integer.valueOf(strAge));
        service.addStudent(student);

        //给用户显示请求的处理结果
        request.getRequestDispatcher("/show.jsp").forward(request, response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
