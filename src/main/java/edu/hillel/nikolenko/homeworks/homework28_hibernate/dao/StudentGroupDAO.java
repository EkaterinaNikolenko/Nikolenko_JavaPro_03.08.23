package edu.hillel.nikolenko.homeworks.homework28_hibernate.dao;

import edu.hillel.nikolenko.homeworks.homework28_hibernate.session.HibernateSession;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.StudentGroup;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class StudentGroupDAO {
    public StudentGroup getGroup(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        StudentGroup group = session.get(StudentGroup.class, id);
        session.close();
        return group;
    }

    public void saveGroup(StudentGroup group) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(group);
        transaction.commit();
        session.close();
    }

    public void updateGroup(StudentGroup group) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(group);
        transaction.commit();
        session.close();
    }

    public void deleteGroup(int id) {
        Session session = HibernateSession.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        StudentGroup group = session.get(StudentGroup.class, id);
        session.delete(group);
        transaction.commit();
        session.close();
    }

    public List<StudentGroup> getAllGroups() {
        Session session = HibernateSession.getSessionFactory().openSession();
        List<StudentGroup> groups = session.createQuery("from StudentGroup", StudentGroup.class).list();
        session.close();
        return groups;
    }
}
