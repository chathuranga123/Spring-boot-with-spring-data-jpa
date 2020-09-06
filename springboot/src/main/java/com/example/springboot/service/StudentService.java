package com.example.springboot.service;

import com.example.springboot.model.Student;

public interface StudentService {

    Student save(Student student);

    Student fetchStudentById(Integer integer);
}
