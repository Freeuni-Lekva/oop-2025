package main;

import dao.StudentDAO;
import dao.StudentDAOImpl;
import model.Course;
import model.Student;

import java.sql.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/students_db";
        String user = "admin";
        String password = "admin";

        StudentDAO dao = new StudentDAOImpl(url, user, password);
        List<Student> students = dao.getAllStudentsWithCourses();

        for (Student s : students) {
            System.out.println(s.firstName() + " " + s.lastName() + " (" + s.idNumber() + ")");
            for (Course c : s.courses()) {
                System.out.println("  - " + c.courseName() + " (" + c.courseType() + ", " + c.courseCredit() + " credits)");
            }
        }
    }
}