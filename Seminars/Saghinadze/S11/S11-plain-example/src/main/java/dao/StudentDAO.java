package dao;

import model.Student;

import java.util.List;

public interface StudentDAO {
    List<Student> getAllStudentsWithCourses();
}