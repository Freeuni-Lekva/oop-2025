import dao.StudentDAO;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.SQLException;

public class Main {

    private static final String URL = "jdbc:mysql://localhost:3306/students_db";

    public static void main(String[] args) throws SQLException {
        try (BasicDataSource basicDataSource = new BasicDataSource()) { // try-with-resources
                basicDataSource.setUrl(URL);
                basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
                basicDataSource.setUsername("root");
                basicDataSource.setPassword("root");

            StudentDAO dao = new StudentDAO(basicDataSource.getConnection());
            System.out.println(dao.getAllStudents());
        }
    }
}
