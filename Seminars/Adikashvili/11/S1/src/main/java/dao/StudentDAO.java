package dao;

import bean.Course;
import bean.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static util.Converter.toCourse;
import static util.Converter.toStudent;

public class StudentDAO {

    private final Connection connection;

    public StudentDAO(Connection connection) {
        this.connection = connection;
    }

    public List<Student> getAllStudents() {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM STUDENTS");

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                students.add(toStudent(resultSet));
            }

            return students;
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return null;
    }

    public Student getStudentById(int studentId) {
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE student_id = ?");
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                return toStudent(resultSet);
            }
        } catch (SQLException exception) {
            System.out.println(exception);
        }
        return null;
    }

    public List<Student> getStudentsByFirstName(String firstName) { // firstName = 'shota or 1=1'
        try {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM STUDENTS WHERE firstname = ?");
            statement.setString(1, firstName);

            ResultSet resultSet = statement.executeQuery();

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                students.add(toStudent(resultSet));
            }
            return students;
        } catch (SQLException exception) {
            System.out.println("students not found");
        }
        return null;
    }

    public List<Course> getStudentCourses(int studentId) {
        try {
            PreparedStatement statement = connection.prepareStatement("select c.*\n" +
                    "from courses c\n" +
                    "left join student_courses sc on c.id = sc.course_id\n" +
                    "where sc.student_id = ?;");
            statement.setInt(1, studentId);
            ResultSet resultSet = statement.executeQuery();

            List<Course> courses = new ArrayList<>();

            while (resultSet.next()) {
                courses.add(toCourse(resultSet));
            }

            return courses;

        } catch (SQLException exception) {
            System.out.println("courses not found");
        }
        return null;
    }
}
