package edu.hillel.nikolenko.homeworks.homework28_hibernate;

import edu.hillel.nikolenko.homeworks.homework28_hibernate.dao.CourseDAO;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.dao.StudentDAO;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.dao.StudentGroupDAO;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.Course;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.Student;
import edu.hillel.nikolenko.homeworks.homework28_hibernate.entity.StudentGroup;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();
        CourseDAO courseDAO = new CourseDAO();
        StudentGroupDAO groupDAO = new StudentGroupDAO();

        Student student1 = new Student();
        student1.setName("John");
        student1.setEmail("john@example.com");
        Student student2 = new Student();
        student2.setName("Kim");
        student2.setEmail("kim@example.com");
        Student student3 = new Student();
        student3.setName("Jane");
        student3.setEmail("jane@example.com");

        Course course1 = new Course();
        course1.setName("Mathematics");
        Course course2 = new Course();
        course2.setName("Physics");

        StudentGroup group1 = new StudentGroup();
        group1.setName("Group 1");
        StudentGroup group2 = new StudentGroup();
        group2.setName("Group");

        courseDAO.saveCourse(course1);
        courseDAO.saveCourse(course2);
        groupDAO.saveGroup(group1);
        groupDAO.saveGroup(group2);

        group1.getStudents().add(student1);
        student1.setGroup(group1);
        group1.getStudents().add(student2);
        student2.setGroup(group1);
        group2.getStudents().add(student3);
        student3.setGroup(group2);

        course1.getStudents().add(student1);
        student1.getCourses().add(course1);
        course1.getStudents().add(student2);
        student2.getCourses().add(course1);
        course2.getStudents().add(student3);
        student3.getCourses().add(course2);

        studentDAO.saveStudent(student1);
        studentDAO.saveStudent(student2);
        studentDAO.saveStudent(student3);

        Student retrievedStudent = studentDAO.getStudent(1);
        System.out.println("Retrieved student: " + retrievedStudent.getName());

        Course retrievedCourse = courseDAO.getCourse(1);
        System.out.println("Retrieved course: " + retrievedCourse.getName());

        StudentGroup retrievedGroup = groupDAO.getGroup(1);
        System.out.println("Retrieved group: " + retrievedGroup.getName());

        student1.setName("Steve");
        studentDAO.updateStudent(student1);
        System.out.println("Updated student: " + studentDAO.getStudent(1).getName());

        group2.setName("Group 2");
        groupDAO.updateGroup(group2);
        System.out.println("Updated group: " + groupDAO.getGroup(2).getName());

        course2.setName("Chemistry");
        courseDAO.updateCourse(course2);
        System.out.println("Updated course: " + courseDAO.getCourse(2).getName());

        List<Student> allStudents = studentDAO.getAllStudents();
        System.out.println("All students: " + allStudents.size());

        List<StudentGroup> allGroups = groupDAO.getAllGroups();
        System.out.println("All groups: " + allGroups.size());

        List<Course> allCourses = courseDAO.getAllCourses();
        System.out.println("All courses: " + allCourses.size());

        studentDAO.deleteStudent(1);
        System.out.println("Deleted student. All students now: " + studentDAO.getAllStudents().size());
    }
}
