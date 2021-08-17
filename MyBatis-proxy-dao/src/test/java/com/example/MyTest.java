package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest {
    @Test
    public void testSelectById(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectById(1002);
        System.out.println(student);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testSelectStudents(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao  = session.getMapper(StudentDao.class);
        //com.sun.proxy.$Proxy == StudentDaoImpl
        System.out.println(dao.getClass().getName());
        List<Student> students = dao.selectStudents();
        students.forEach(stu -> System.out.println(stu));
        session.close();
    }
}
