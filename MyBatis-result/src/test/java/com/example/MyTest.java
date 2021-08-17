package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import com.example.vo.CustomObject;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;
import java.util.Map;

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
    public void testSelectById2(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        CustomObject co = dao.selectById2(1002);
        System.out.println(co);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testCountStudent(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        long nums = dao.countStudent();
        System.out.println(nums);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testSelectMap(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        Map<Object, Object> map = dao.selectMap(1001);
        System.out.println(map);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    // 使用列别名查询
    public void testSelectById3(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);
        CustomObject co = dao.selectById3(1002);
        System.out.println(co);
        //3.关闭SqlSession对象
        session.close();
    }

    @Test
    public void testLikeOne(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> list = dao.selectLikeOne("%李%");
        session.close();

        list.forEach(s -> System.out.println(s));
    }

    @Test
    public void testLikeTwo(){
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        List<Student> list = dao.selectLikeTwo("李");
        session.close();

        list.forEach(s -> System.out.println(s));
    }
}
