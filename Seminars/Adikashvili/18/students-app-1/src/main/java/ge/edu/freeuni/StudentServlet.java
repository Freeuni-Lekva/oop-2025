package ge.edu.freeuni;

import bean.Student;
import filter.AllFilter;
import filter.Filter;
import filter.FilterBuilder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class StudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // get all cookies
        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("name")) {
                    request.setAttribute("student_name", cookie.getValue());
                    break;
                }
            }
        }

        Filter filter = FilterBuilder.build(request); // get filter from request
        request.setAttribute("filter", filter);

        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");

        Student student = new Student(firstName, lastName);

        StudentDao dao = (StudentDao) request.getServletContext().getAttribute("store");
        dao.addStudent(student);

        response.addCookie(new Cookie("name", student.getFirstName()));
        response.sendRedirect("/student");
    }
}
