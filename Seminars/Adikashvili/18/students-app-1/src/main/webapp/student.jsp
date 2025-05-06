<%@ page import="ge.edu.freeuni.StudentDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="ge.edu.freeuni.StudentDao" %>
<%@ page import="ge.edu.freeuni.Student" %>
<%@ page import="java.util.List" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<%
    String name = (String)request.getAttribute("student_name");
    if (name != null) {
%>
<div>Hello <%= name %> </div>

<% } else { %>
<form id="students-form" action="/student" method="post">
    <label for="first-name">
        <input type="text" placeholder="enter first name" name="first-name" id="first-name"/>
    </label>
    <label for="last-name">
        <input type="text" placeholder="enter last name" name="last-name" id="last-name"/>
    </label>
    <input type="submit" value="Add Student"/>
</form>
<% } %>

<form action="/student" method="get">
    <label for="first-name">
        <input type="text" placeholder="enter first name" name="first-name"/>
    </label>
    <label for="last-name">
        <input type="text" placeholder="enter last name" name="last-name"/>
    </label>
    <input type="submit" value="Search"/>
</form>

<table id="students-table">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <% StudentDao dao = (StudentDao) application.getAttribute("store");
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
