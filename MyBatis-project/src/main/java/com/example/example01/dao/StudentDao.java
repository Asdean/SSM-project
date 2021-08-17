package com.example.example01.dao;

import com.example.example01.domain.Student;

public interface StudentDao {
    // 查询数据
    Student selectStudentById(Integer id);

    // 添加数据
    // int为添加数据行数
    int insertStudent(Student student);
}
