package com.example.service.impl;

import com.example.dao.StudentDao;
import com.example.domain.Student;
import com.example.service.StudentService;

/**
 *
 */
public class StudentServiceImpl implements StudentService {

    private StudentDao dao;

    public void setDao(StudentDao dao) {
        this.dao = dao;
    }

    @Override
    public int addStudent(Student student) {
        int rows = dao.insertStudent(student);

        return rows;
    }

    @Override
    public Student findStudentById(Integer id) {

        Student student = dao.selectById(id);
        return student;
    }
}
