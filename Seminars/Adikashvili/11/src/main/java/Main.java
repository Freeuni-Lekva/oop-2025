import dao.StudentDAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/students_db", "root", "root");

        StudentDAO studentDAO = new StudentDAO(connection);

        System.out.println(studentDAO.getAllStudents());
        System.out.println(studentDAO.getStudentById(1));

        System.out.println(studentDAO.getStudentsByFirstName("shota"));
        // courses
        System.out.println(studentDAO.getStudentCourses(1));
    }
}
