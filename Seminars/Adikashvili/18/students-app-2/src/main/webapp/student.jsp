<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%@ page import="com.example.StudentsDao" %>
<%@ page import="static com.example.Constants.DAO_KEY" %>
<%@ page import="com.example.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="filter.Filter" %>
<%@ page import="filter.FilterBuilder" %>
<%@ page import="static com.example.Constants.COOKIE_USER_NAME" %>

<html>
<head>
    <title>Students App</title>
    <link rel="stylesheet" href="student.css" />
</head>
<body>

<% String name = (String) request.getAttribute(COOKIE_USER_NAME);
    if (name == null) {
%>
<form id="students-form" action="/student" method="post">
    <input type="text" placeholder="enter first name" name="first-name"/>
    <input type="text" placeholder="enter last name" name="last-name"/>
    <input type="submit" value="Add student"/>
</form>
<% } else { %>
<div>Hello <%= name %>
</div>
<% } %>

<form action="/student" method="get">
    <input type="text" placeholder="enter first name" name="first-name"/>
    <input type="text" placeholder="enter last name" name="last-name"/>
    <input type="submit" value="Search student"/>
</form>

<table id="students-table">
    <tr>
        <th>First Name</th>
        <th>Last Name</th>
    </tr>
    <%
        StudentsDao dao = (StudentsDao) application.getAttribute(DAO_KEY);
        Filter filter = FilterBuilder.build(request);
        List<Student> students = dao.filterStudents(filter);

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
