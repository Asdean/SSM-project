package com.example.dao;

import com.example.domain.Student;

import java.util.List;

// 动态SQL
public interface StudentDao {
    // if
    List<Student> selectIf(Student student);

    // where
    List<Student> selectWhere(Student student);

    // foreach-1
    List<Student> selectForEach1(List<Integer> idList);

    // foreach-2
    List<Student> selectForEach2(List<Student> studentsList);

    // pagehelper
    List<Student> selectAllStudents();
}
