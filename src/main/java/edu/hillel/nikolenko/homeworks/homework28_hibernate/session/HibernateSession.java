package edu.hillel.nikolenko.homeworks.homework28_hibernate.session;

import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.Course;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.Student;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.StudentGroup;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSession {
    private static SessionFactory sessionFactory;

    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            configuration.addAnnotatedClass(Student.class);
            configuration.addAnnotatedClass(Course.class);
            configuration.addAnnotatedClass(StudentGroup.class);
            sessionFactory = configuration.buildSessionFactory();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }
}
