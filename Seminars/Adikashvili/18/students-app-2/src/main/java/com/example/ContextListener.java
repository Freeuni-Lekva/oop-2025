package com.example;

import org.apache.commons.dbcp2.BasicDataSource;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import java.sql.SQLException;

import static com.example.Constants.DAO_KEY;
import static com.example.Constants.URL;

public class ContextListener implements ServletContextListener {

    private BasicDataSource basicDataSource;

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // database connection
        basicDataSource = new BasicDataSource();
        basicDataSource.setUrl(URL);
        basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        basicDataSource.setUsername("root");
        basicDataSource.setPassword("root");

        StudentsDao studentsDao = new MySQLStudentsDao(basicDataSource);

        // global servlet context
        ServletContext context = sce.getServletContext();
        context.setAttribute(DAO_KEY, studentsDao);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        try {
            basicDataSource.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
