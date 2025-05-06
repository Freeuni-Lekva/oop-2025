package com.example;

import filter.Filter;

import java.util.List;

public interface StudentsDao {

    void addStudent(Student student);

    List<Student> getAllStudents();

    List<Student> filterStudents(Filter filter);
}
