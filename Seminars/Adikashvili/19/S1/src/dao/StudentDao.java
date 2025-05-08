package dao;

import bean.Student;

import java.util.List;

public interface StudentDao {

    void addStudent(Student student);

    Student getStudentById(int id);

    void removeStudent(Student student);

    List<Student> getAllStudents();
}
