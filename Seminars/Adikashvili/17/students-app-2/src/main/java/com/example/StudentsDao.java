package com.example;

import java.util.List;

public interface StudentsDao {

    void addStudent(Student student);

    List<Student> getAllStudents();
}
