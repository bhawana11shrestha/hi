package com.example.dao;

import com.example.model.Student;
import com.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.EmptyStackException;

public class StudentDao {
    public void saveStudent(Student student){
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSessionFactory().openSession()) {
            transaction = session.beginTransaction();
            session.save(student);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

    public void update(Student student){
        Transaction transaction = null;
        try( Session session = HibernateUtil.getSessionFactory().openSession()){
            transaction = session.beginTransaction();
            session.update(student);
            transaction.commit();
        } catch (Exception e){
            if(transaction !=  null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}

