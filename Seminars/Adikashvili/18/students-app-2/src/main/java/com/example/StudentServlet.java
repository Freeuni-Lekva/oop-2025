package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.Constants.COOKIE_USER_NAME;
import static com.example.Constants.DAO_KEY;

public class StudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Cookie[] cookies = request.getCookies();

        for (Cookie cookie : cookies) {
            if (cookie.getName().equals(COOKIE_USER_NAME)) {
                request.setAttribute(COOKIE_USER_NAME, cookie.getValue());
                break;
            }
        }

        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String firstName = request.getParameter("first-name");
        String lastName = request.getParameter("last-name");

        Student newStudent = new Student(firstName, lastName);

        ServletContext context = request.getServletContext();
        StudentsDao dao = (StudentsDao) context.getAttribute(DAO_KEY);

        dao.addStudent(newStudent);

        response.addCookie(new Cookie(COOKIE_USER_NAME, newStudent.getFirstName()));
        response.sendRedirect("/student");
    }

}
