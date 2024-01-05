package edu.hillel.nikolenko.homeworks.homework28_hibernate;

import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.LinkedList;
import java.util.List;

public class CourseDAO {
    public Course getCourse(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Course course = session.get(Course.class, id);
        session.close();
        return course;
    }

    public void saveCourse(Course course) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(course);
        transaction.commit();
        session.close();
    }

    public void updateCourse(Course course) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(course);
        transaction.commit();
        session.close();
    }

    public void deleteCourse(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Course course = session.get(Course.class, id);
        session.delete(course);
        transaction.commit();
        session.close();
    }

    public List<Course> getAllCourses() {
        Session session = HibernateSession.getSessionFactory().openSession();
        List<Course> courses = session.createQuery("from Course", Course.class).list();
        session.close();
        return courses;
    }
}
