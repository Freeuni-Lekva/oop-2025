package util;

import bean.Course;
import bean.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Converter {

    public static Student toStudent(ResultSet resultSet) throws SQLException {
        return new Student(
                resultSet.getInt("id"),
                resultSet.getInt("student_id"),
                resultSet.getString("idnumber"),
                resultSet.getString("firstname"),
                resultSet.getString("lastname"),
                resultSet.getDate("register_date")
        );
    }

    public static Course toCourse(ResultSet resultSet) throws SQLException {
        return new Course(
                resultSet.getInt("id"),
                resultSet.getInt("course_id"),
                resultSet.getString("course_name"),
                resultSet.getInt("course_credit"),
                resultSet.getString("course_type")
        );
    }
}
