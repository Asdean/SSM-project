package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import com.example.vo.QueryParam;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MyTest {
    @Test
    public void testSelectById(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Student student = dao.selectById(1001);
        System.out.println(student);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testOneParameter(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectByEmail("lisi@email.com");
        System.out.println(student);
        sqlSession.close();
    }

    @Test
    public void testSelectByNameOrAge(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectByNameOrAge("李四", 20);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectByObject(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = Student.builder()
                .name("张三")
                .age(22).build();
        List<Student> students = dao.selectByObject(student);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectByQueryParam(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = QueryParam.builder()
                .p1("张三")
                .p2("20").build();
        List<Student> students = dao.selectByQueryParam(param);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectByPosition(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "李四";
        Integer age = 20;
        List<Student> students = dao.selectByPosition(name, age);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testSelectByMap(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<String, Object> data = new HashMap<>();
        data.put("name", "李四");
        data.put("age", 20);
        List<Student> students = dao.selectStudentByMap(data);
        students.forEach(stu -> System.out.println(stu));
        sqlSession.close();
    }

    @Test
    public void testUpdateStudent(){
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = Student.builder()
                .id(1002)
                .name("李")
                .email("li@email.com").build();
        int rows = dao.updateStudent(student);
        sqlSession.commit();
        System.out.println(rows);
        sqlSession.close();
    }
}
