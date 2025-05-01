<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.example.StudentsDao" %>
<%@ page import="static com.example.Constants.DAO_KEY" %>
<%@ page import="com.example.Student" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Students App</title>
</head>
<body>

<form id="students-form" action="/student" method="post">
    <input type="text" placeholder="enter first name" name="first-name"/>
    <input type="text" placeholder="enter last name" name="last-name"/>
    <input type="submit" value="Add student"/>
</form>

<table id="students-table">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <%
        StudentsDao dao = (StudentsDao) application.getAttribute(DAO_KEY);
        List<Student> students = dao.getAllStudents();

        for (Student student : students) {
    %>
    <tr>
        <td><%= student.getFirstName() %>
        </td>
        <td><%= student.getLastName() %>
        </td>
    </tr>
    <% } %>
</table>

</body>
</html>
