package ge.edu.freeuni;

import bean.Student;
import filter.AllFilter;
import filter.Filter;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MySQLDao implements StudentDao {

    private BasicDataSource basicDataSource;

    public MySQLDao(BasicDataSource basicDataSource) {
        this.basicDataSource = basicDataSource;
    }

    @Override
    public void addStudent(Student student) {
        try (Connection connection = basicDataSource.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO students (first_name, last_name) VALUES (?,?);");
            preparedStatement.setString(1, student.getFirstName());
            preparedStatement.setString(2, student.getLastName());

            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void removeStudent(Student student) {

    }

    @Override
    public List<Student> getAllStudents() {
        return filterStudents(new AllFilter());
    }

    public List<Student> filterStudents(Filter filter) {
        try (Connection connection = basicDataSource.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT first_name, last_name from students WHERE " + filter.toString());

            List<Student> result = new ArrayList<>();

            while (resultSet.next()) {
                result.add(new Student(resultSet.getString("first_name"), resultSet.getString("last_name")));
            }

            return result;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
