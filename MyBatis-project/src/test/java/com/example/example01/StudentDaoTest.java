package com.example.example01;

import com.example.example01.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class StudentDaoTest {
    @Test
    public void SelectStudentById_test() throws IOException {
        // 调用mybatis某个对象的方法，执行mapper文件中的sql语句
        // mybatis核心类：SqlSessionFactory

        // 1.定义mybatis主配置文件的位置,从类路径开始的相对路径
        String config="mybatis.xml";
        // 2.读取主配置文件。使用mybatis框架中的Resources类
        InputStream inputStream = Resources.getResourceAsStream(config);
        // 3.创建SqlSessionFactory对象，使用SqlSessionFactoryBuilder类
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        /*
        try(SqlSession session = factory.openSession()) {
            String sqlId = "com.example.example01.dao.StudentDao" + "." + "selectStudentById";
            Student student = session.selectOne(sqlId, 1001);
        } finally {
            session.close();
        }
        */

        // 4.获取SqlSession对象。
        SqlSession session = factory.openSession();

        // 5.指定要执行的sql语句的 id
        // sql的id = namespace + "." + select|update|insert|delete标签的id属性值
        String sqlId = "com.example.example01.dao.StudentDao" + "." + "selectStudentById";

        // 6.通过SqlSession的方法，执行sql语句
        Student student = session.selectOne(sqlId, 1001);
        System.out.println(student);

        // 7.关闭SqlSession对象
        session.close();
    }

    @Test
    public void InsertStudent_test() throws IOException {
        String config = "mybatis.xml";
        InputStream inputStream  = Resources.getResourceAsStream(config);
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);

        SqlSession session = factory.openSession(true);

        // 5.指定要执行的sql语句的 id
        // sql的id = namespace + "." + select|update|insert|delete标签的id属性值
        String sqlId = "com.example.example01.dao.StudentDao.insertStudent";

        // 6.通过SqlSession的方法，执行sql语句
        Student student = Student.builder()
                .id(1002)
                .name("李四")
                .email("lisi@email.com")
                .age(22).build();
        /*student.setId(1001);
        student.setName("张三");
        student.setEmail("lisi@email.com");
        student.setAge(20);*/
        int rows = session.insert(sqlId, student);
        System.out.println(rows);

        // mybatis默认执行sql语句是 手工提交事务 模式，在做insert，update，delete后需要提交事务。
        // session.commit();

        // 7.关闭SqlSession对象
        session.close();
    }
}
