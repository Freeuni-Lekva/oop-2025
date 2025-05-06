package ge.edu.freeuni;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.SQLException;

public class ContextListener implements ServletContextListener {

    private static final String URL = "jdbc:mysql://localhost:3306/students_db";

    private BasicDataSource basicDataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(URL);
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");

        StudentDao studentDao = new MySQLDao(basicDataSource);

        ServletContext context = sce.getServletContext();
        context.setAttribute("store", studentDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            basicDataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
