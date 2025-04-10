import bean.Student;
import dao.StudentDAO;
import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class StudentDAOTest {

    private static BasicDataSource basicDataSource;

    private StudentDAO studentDAO;

    @BeforeAll
    public static void setUpDatabase() throws SQLException {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl("jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1");
        basicDataSource.setUsername("sa"); // h2 username
        basicDataSource.setPassword(""); // h2 password

        Connection connection = basicDataSource.getConnection();
        Statement statement = connection.createStatement();

        // create tables
        statement.execute("CREATE TABLE courses\n" +
                "(\n" +
                "    id            INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    course_id     INT          NOT NULL,\n" +
                "    course_name   VARCHAR(255) NOT NULL,\n" +
                "    course_credit INT          NOT NULL DEFAULT 0,\n" +
                "    course_type   VARCHAR(255),\n" +
                "    CONSTRAINT courses_uk UNIQUE (course_id)\n" +
                ");");
        statement.execute("CREATE TABLE students\n" +
                "(\n" +
                "    id            INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    student_id    INT          NOT NULL,\n" +
                "    idnumber      CHAR(11)     NOT NULL,\n" +
                "    firstname     VARCHAR(100) NOT NULL,\n" +
                "    lastname      VARCHAR(100) NOT NULL,\n" +
                "    register_date DATETIME     NOT NULL DEFAULT NOW(),\n" +
                "    CONSTRAINT students_uk1 UNIQUE (student_id),\n" +
                "    CONSTRAINT students_uk2 UNIQUE (idnumber)\n" +
                ");");
        statement.execute("CREATE TABLE student_courses\n" +
                "(\n" +
                "    id         INT PRIMARY KEY AUTO_INCREMENT,\n" +
                "    course_id  INT NOT NULL,\n" +
                "    student_id INT NOT NULL,\n" +
                "    CONSTRAINT student_courses_uk1 UNIQUE (course_id, student_id),\n" +
                "    CONSTRAINT student_courses_fk1 FOREIGN KEY (course_id)\n" +
                "        REFERENCES courses (id),\n" +
                "    CONSTRAINT student_courses_fk2 FOREIGN KEY (student_id)\n" +
                "        REFERENCES students (id)\n" +
                ");");

        // insert data
        statement.executeUpdate("insert into students (student_id, idnumber, firstName, lastName)\n" +
                "values (1, '11111111111', 'shota', 'gvinepadze'),\n" +
                "       (2, '11111111112', 'giorgi', 'adikashvili'),\n" +
                "       (3, '11111111113', 'giorgi', 'saghinadze');");
        statement.executeUpdate("INSERT INTO courses (course_id, course_name, course_credit, course_type)\n" +
                "VALUES (1, 'Linear Algebra', 4, 'MATH'),\n" +
                "       (2, 'Programming Paradigms', 6, 'CS'),\n" +
                "       (3, 'Calculus I', 6, 'MATH'),\n" +
                "       (4, 'OOP', 6, 'CS'),\n" +
                "       (5, 'Quantum Algorithms', 7, 'CS'),\n" +
                "       (6, 'Nand To Tetris', 6, 'CS');");
        statement.execute("insert into student_courses (student_id, course_id)\n" +
                "select s.id, c.id\n" +
                "from students s\n" +
                "inner join courses c\n" +
                "where (s.firstname = 'shota' and c.course_credit = 7)\n" +
                "   or (s.firstname = 'shota' and c.course_credit = 4);");
    }

    @BeforeEach
    public void setUpDAO() throws SQLException {
        studentDAO = new StudentDAO(basicDataSource.getConnection());
    }

    @Test
    public void testGetAllStudents() {
        List<Student> students = studentDAO.getAllStudents();
        assertEquals(3, students.size());
        assertEquals("shota", students.get(0).getFirstName());
    }

    @Test
    public void testGetByID() {
        Student student = studentDAO.getStudentById(1);
        assertNotNull(student);
        assertEquals("shota", student.getFirstName());
    }

    @Test
    public void testGetByIDNull() {
        Student student = studentDAO.getStudentById(100);
        assertNull(student);
    }
}
