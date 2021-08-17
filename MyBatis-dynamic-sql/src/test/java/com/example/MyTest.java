package com.example;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.utils.MyBatisUtil;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    @Test
    public void testSelectIf() {
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        /*Student student = Student.builder()
                .name("李")
                .age(20).build();*/

        /*Student student = Student.builder()
                .name("李").build();*/

        Student student = Student.builder()
                .name(null)
                .age(20).build();
        List<Student> list = dao.selectIf(student);
        list.forEach(l -> System.out.println(l));
        session.close();
    }

    @Test
    public void testSelectWhere() {
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);
        /*Student student = Student.builder()
                .name("李")
                .age(20).build();*/

        /*Student student = Student.builder()
                .name("李").build();*/

        Student student = Student.builder()
                .name(null)
                .age(20).build();
        List<Student> list = dao.selectWhere(student);
        list.forEach(l -> System.out.println(l));
        session.close();
    }

    @Test
    // 手工实现循环处理
    public void testFor(){
        List<Integer> idlist = new ArrayList<>();
        idlist.add(1001);
        idlist.add(1002);
        idlist.add(1003);

        // 查询 id 在 idlist中的student
        // select * from student where id in (1001,1002,1003)

        StringBuffer sql= new StringBuffer("");
        sql.append("select * from student where id in ");

        //使用循环， 把List数据 追加到 sql 字符串中。

        //循环之前加入 (
        sql.append("(");
        for(int i=0;i< idlist.size();i++){
            Integer item  = idlist.get(i);// item是集合成员
            sql.append(item);//添加成员到 sql字符串
            sql.append(","); //集合成员之间的分隔符
        }
        sql.deleteCharAt( sql.length()-1) ;

        //循环之后，加入 )
        sql.append(")");

        System.out.println("sql -> "+sql);
    }

    @Test
    public void testSelectForEach1() {
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Integer> list = new ArrayList<>();
        list.add(1001);
        list.add(1002);

        List<Student> lists = dao.selectForEach1(list);
        lists.forEach(l -> System.out.println(l));
        session.close();
    }

    @Test
    public void testSelectForEach2() {
        SqlSession session = MyBatisUtil.getSqlSession();
        StudentDao dao = session.getMapper(StudentDao.class);

        List<Student> list = new ArrayList<>();
        list.add(Student.builder().id(1001).build());
        list.add(Student.builder().id(1002).build());

        List<Student> lists = dao.selectForEach2(list);
        lists.forEach(l -> System.out.println(l));
        session.close();
    }

    @Test
    public void testPageHelper(){
        //1.获取SqlSession
        SqlSession session = MyBatisUtil.getSqlSession();
        //2.获取dao的代理
        StudentDao dao = session.getMapper(StudentDao.class);


        //调用PageHelper的方法
        PageHelper.startPage(1,2);
        List<Student> students  = dao.selectAllStudents();

        students.forEach( stu-> System.out.println(stu));
        //3.关闭SqlSession对象
        session.close();
    }
}
