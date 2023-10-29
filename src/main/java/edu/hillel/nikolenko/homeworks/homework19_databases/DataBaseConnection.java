package edu.hillel.nikolenko.homeworks.homework19_databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/hw19_schema";
        String username = "root";
        String password = "MySQL_Nikolenko_12";


        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            LessonDao studentDao = new LessonDao(connection);
            studentDao.addLesson(new Lesson("test", new Homework(1,"name", "desc")));
            System.out.println(studentDao.getLessons());
            studentDao.deleteLesson(1);
            System.out.println(studentDao.getLessons());
            System.out.println(studentDao.getOneLesson(5));
        }
    }


}
