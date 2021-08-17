package com.example.example03;

import com.example.example03.School;

public class Student {
    private String name;
    private int age;

    private School school;

    public Student() {
        System.out.println("Student的无参数构造方法");
    }

    public Student(String name, int age, School school) {
        System.out.println("Student的有参数构造方法");
        this.name = name;
        this.age = age;
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }

}
