package ge.edu.freeuni;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        // database connection

        StudentDao studentDao = new StudentDaoImpl();

        ServletContext context = sce.getServletContext();
        context.setAttribute("store", studentDao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        // database connection
    }

}
