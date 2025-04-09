package dao;

import model.Course;
import model.Student;

import java.sql.*;
import java.util.*;

public class StudentDAOImpl implements StudentDAO {
    private final String url;
    private final String username;
    private final String password;

    public StudentDAOImpl(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public List<Student> getAllStudentsWithCourses() {
        List<Student> students = new ArrayList<>();
        String sql = """
            SELECT
                s.idNumber, s.firstName, s.lastName, s.registrationDate,
                c.courseName, c.courseCredit, c.courseType
            FROM students s
            JOIN student_courses sc ON s.id = sc.student_id
            JOIN courses c ON sc.course_id = c.id
        """;


        try (Connection conn = DriverManager.getConnection(url, username, password);
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            Map<String, Student> studentMap = new HashMap<>();

            while (rs.next()) {
                String idNumber = rs.getString("idNumber");
                Student student = studentMap.getOrDefault(idNumber, new Student(idNumber, rs.getString("firstName"),
                        rs.getString("lastName"), rs.getDate("registrationDate"), new ArrayList<>()));

                if (!studentMap.containsKey(idNumber)) {
                    studentMap.put(idNumber, student);
                }

                Course course = new Course(rs.getString("courseName"), rs.getInt("courseCredit"), rs.getString("courseType"));

                studentMap.get(idNumber).courses().add(course);
            }

            students.addAll(studentMap.values());

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return students;
    }
}
