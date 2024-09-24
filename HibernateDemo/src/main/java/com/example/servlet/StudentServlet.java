package com.example.servlet;

import com.example.dao.StudentDao;
import com.example.model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/students")
public class StudentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");

        Student student = new Student();
        student.setName(name);
        student.setEmail(email);

        StudentDao studentDao = new StudentDao();
        studentDao.saveStudent(student);

        response.sendRedirect("index.jsp");
    }
}
