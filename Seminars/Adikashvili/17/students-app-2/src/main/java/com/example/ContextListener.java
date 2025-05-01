package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import static com.example.Constants.DAO_KEY;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // database connection

        StudentsDao studentsDao = new StudentsDaoImpl();

        // global servlet context
        ServletContext context = sce.getServletContext();
        context.setAttribute(DAO_KEY, studentsDao);
    }

    public void contextDestroyed(ServletContextEvent sce) {
        // database closed
    }
}
