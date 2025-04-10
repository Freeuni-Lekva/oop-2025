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

    public List<Student> getAllStudents() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(toStudent(resultSet));
        }

        return students;
    }

    public Student getStudentById(int id) throws SQLException {
        PreparedStatement statement = connection.prepareStatement("SELECT * FROM students WHERE student_id = ?");
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            return toStudent(resultSet);
        }
        return null;
    }

    public List<Student> getAllStudentByName(String firstName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM students WHERE firstname = ?");
        preparedStatement.setString(1, firstName);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Student> students = new ArrayList<>();
        while (resultSet.next()) {
            students.add(toStudent(resultSet));
        }

        return students;
    }

    public List<Course> getStudentCourses(int studentId) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement("select c.*\n" +
                "from courses c\n" +
                "left join student_courses sc on c.id = sc.course_id\n" +
                "where sc.student_id = ?;");
        preparedStatement.setInt(1, studentId);
        ResultSet resultSet = preparedStatement.executeQuery();

        List<Course> courses = new ArrayList<>();

        while (resultSet.next()) {
            courses.add(toCourse(resultSet));
        }
        return courses;
    }
}
