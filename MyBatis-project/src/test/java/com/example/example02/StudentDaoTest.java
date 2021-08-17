package com.example.example02;

import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class StudentDaoTest {
    @Test

    public void testSelectById(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.指定sqlId
        String sqlId = "com/example/dao/StudentDao.selectById";
        //3.执行SqlSession的方法，表示执行sql语句
        Student student = session.selectOne(sqlId, 1001);
        System.out.println(student);
        //4.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testSelectStudents(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.example.example2.dao.StudentDao.selectStudents";
        //3.执行SqlSession的方法，表示执行sql语句
        List<Student> students = session.selectList(sqlId);

        for(Student stu : students){
            System.out.println(stu);
        }

        //4.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testInsertStudent(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.example.example2.dao.StudentDao.insertStudent";
        //3.执行SqlSession的方法，表示执行sql语句

        Student student = new Student();
        student.setId(1003);
        student.setName("王五");
        student.setEmail("wangwu@email.com");
        student.setAge(30);
        int rows = session.insert(sqlId, student);
        session.commit();
        System.out.println(rows);

        //4.关闭SqlSession对象
        session.close();
    }
}
