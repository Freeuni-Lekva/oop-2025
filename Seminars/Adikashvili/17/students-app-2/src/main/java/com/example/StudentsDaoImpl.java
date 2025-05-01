package com.example;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class StudentsDaoImpl implements StudentsDao {

    List<Student> students;

    public StudentsDaoImpl() {
        this.students = new Vector<>();
    }

    @Override
    public void addStudent(Student student) {
        this.students.add(student);
    }

    @Override
    public List<Student> getAllStudents() {
        return Collections.unmodifiableList(students);
    }
}
