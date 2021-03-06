package com.example.dao.impl;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 *
 */
public class StudentDaoImpl implements StudentDao {
    @Override
    public Student selectById(Integer id) {
        SqlSession sqlSession = MyBatisUtil.getSqlSession();
        String sqlId = "com.example.dao.StudentDao.selectById";
        Student student = sqlSession.selectOne(sqlId, id);
        sqlSession.close();
        return student;
    }

    @Override
    public List<Student> selectStudents() {

        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.example.dao.StudentDao.selectStudents";
        //3.执行SqlSession的方法，表示执行sql语句
        List<Student> students= session.selectList(sqlId);
        //4.关闭SqlSession对象
        session.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.指定sqlId
        String sqlId = "com.example.dao.StudentDao.insertStudent";
        //3.执行SqlSession的方法，表示执行sql语句
        int rows = session.insert(sqlId, student);
        session.commit();
        System.out.println(rows);
        //4.关闭SqlSession对象
        session.close();
        return rows;
    }
}
