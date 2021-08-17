package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class MyTest2 {

    @Test
    public void testQueryStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "'李'"; // 原样传值，不加单引号直接传值李四，不会改为字符串类型
        List<Student> students = dao.queryStudent(name);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testQueryStudentOrderById(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao  = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentOrderById();
        students.forEach( stu-> System.out.println(stu));
        sqlSession.close();

    }

    @Test
    public void testQueryStudentOrderByName(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao  = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentOrderByName();
        students.forEach( stu-> System.out.println(stu));
        sqlSession.close();

    }

    @Test
    public void testQueryStudentOrderByColName(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao  = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.queryStudentOrderByColName("李四","id","student");
        students.forEach( stu-> System.out.println(stu));
        sqlSession.close();

    }
}
