package com.example;

import filter.AllFilter;
import filter.Filter;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.example.Constants.INSERT_INTO;

public class MySQLStudentsDao implements StudentsDao {

    private final BasicDataSource dataSource;

    public MySQLStudentsDao(BasicDataSource basicDataSource) {
        this.dataSource = basicDataSource;
    }

    @Override
    public void addStudent(Student student) {
        try (Connection connection = this.dataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_INTO);
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Student> getAllStudents() {
        return filterStudents(new AllFilter());
    }

    public List<Student> filterStudents(Filter filter) {
        try (Connection connection = this.dataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery("SELECT first_name, last_name FROM students WHERE " + filter.toString());

            List<Student> students = new ArrayList<>();
            while (result.next()) {
                students.add(new Student(result.getString("first_name"), result.getString("last_name")));
            }

            return students;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
