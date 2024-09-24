<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.model.Student" %>
<html>
<head>
    <title>Student List</title>
</head>
<body>
<h2>Student List</h2>
<a href="form.jsp">Add New Student</a>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Actions</th>
    </tr>
    <%
        List<Student> students = (List<Student>) request.getAttribute("students");

        if (students != null && !students.isEmpty()) {
            for (Student student : students) {
    %>
    <tr>
        <td><%= student.getId() %></td>
        <td><%= student.getName() %></td>
        <td><%= student.getEmail() %></td>
        <td>
            <a href="form.jsp?id=<%= student.getId() %>">Edit</a>
            <form action="student" method="post" style="display:inline;">
                <input type="hidden" name="id" value="<%= student.getId() %>">
                <input type="hidden" name="action" value="delete">
                <button type="submit">Delete</button>
            </form>
        </td>
    </tr>
    <%
        }
    } else {
    %>
    <tr>
        <td colspan="4">No students found.</td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
