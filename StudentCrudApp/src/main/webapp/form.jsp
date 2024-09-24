<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Student Form</title>
</head>
<body>
<h2>Student Form</h2>

<form action="student" method="post">
    <input type="hidden" name="id" value="<%= request.getParameter("id") != null ? request.getParameter("id") : "" %>">

    Name: <input type="text" name="name" value="<%= request.getParameter("name") != null ? request.getParameter("name") : "" %>">
    <br>
    Email: <input type="text" name="email" value="<%= request.getParameter("email") != null ? request.getParameter("email") : "" %>">
    <br>

    <input type="hidden" name="action" value="<%= request.getParameter("id") == null ? "create" : "update" %>">
    <button type="submit">Submit</button>
</form>
<a href="list.jsp">Back to List</a>
</body>
</html>
