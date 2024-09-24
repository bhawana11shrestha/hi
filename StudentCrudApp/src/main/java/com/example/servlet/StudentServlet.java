package com.example.servlet;


import com.example.model.Student;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class StudentServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if ("create".equals(action)) {
            createStudent(request);
        } else if ("update".equals(action)) {
            updateStudent(request);
        } else if ("delete".equals(action)) {
            deleteStudent(request);
        }

        response.sendRedirect("list.jsp");
    }

    private void createStudent(HttpServletRequest request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        Student student = new Student();
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));

        session.save(student);
        tx.commit();
        session.close();
    }

    private void updateStudent(HttpServletRequest request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = session.get(Student.class, id);
        student.setName(request.getParameter("name"));
        student.setEmail(request.getParameter("email"));

        session.update(student);
        tx.commit();
        session.close();
    }

    private void deleteStudent(HttpServletRequest request) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        int id = Integer.parseInt(request.getParameter("id"));
        Student student = session.get(Student.class, id);

        session.delete(student);
        tx.commit();
        session.close();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Using HQL to fetch the list of students
        List<Student> students = session.createQuery("from Student", Student.class).list();
        System.out.println("Number of students: " + students.size());

        session.close();

        request.setAttribute("students", students);
        request.getRequestDispatcher("list.jsp").forward(request, response);
    }
}
