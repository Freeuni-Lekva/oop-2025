package com.example;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static com.example.Constants.DAO_KEY;

public class StudentServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

        response.sendRedirect("/student");
    }

}
