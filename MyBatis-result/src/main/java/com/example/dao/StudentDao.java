package com.example.dao;

import com.example.domain.Student;
import com.example.vo.CustomObject;
import com.example.vo.QueryParam;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 */
public interface StudentDao {

    //重载方法
    Student selectById(Integer id);

    CustomObject selectById2(@Param("stuid") Integer id);

    CustomObject selectById3(@Param("stuid") Integer id);

    long countStudent();

    //查询结果返回是一个Map
    Map<Object, Object> selectMap(@Param("stuid") Integer id);

    //like第一种方式
    List<Student> selectLikeOne(@Param("name") String name);
    //like第二种方式
    List<Student> selectLikeTwo(@Param("name") String name);
}
