package com.example.service;

import com.example.domain.Student;

/**
 *
 */
public interface StudentService {

    int addStudent(Student student);

    Student findStudentById(Integer id);//query ,search ,getId
}
