package edu.hillel.nikolenko.homeworks.homework28_hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentDAO {
    public Student getStudent(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Student student = session.get(Student.class, id);
        session.close();
        return student;
    }

    public void saveStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);
        transaction.commit();
        session.close();
    }

    public void updateStudent(Student student) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(student);
        transaction.commit();
        session.close();
    }

    public void deleteStudent(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Student student = session.get(Student.class, id);
        session.delete(student);
        transaction.commit();
        session.close();
    }

    public List<Student> getAllStudents() {
        Session session = HibernateSession.getSessionFactory().openSession();
        List<Student> students = session.createQuery("from Student", Student.class).list();
        session.close();
        return students;
    }
}
