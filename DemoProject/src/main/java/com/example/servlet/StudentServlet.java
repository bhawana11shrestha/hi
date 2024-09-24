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
public class StudentServlet extends HttpServlet{
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException{
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");

        Student student = new Student();
        student.setName(name);
        student.setAddress(address);
        student.setEmail(email);

        StudentDao studentDao = new StudentDao();
        studentDao.saveStudent(student);

        res.sendRedirect("index.jsp");


    }
}
