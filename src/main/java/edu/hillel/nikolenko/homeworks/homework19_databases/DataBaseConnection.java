package edu.hillel.nikolenko.homeworks.homework19_databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection implements AutoCloseable {
    public static final String url = "jdbc:mysql://localhost:3306/hw19_schema";
    public static final String username = "root";
    public static final String password = "MySQL_Nikolenko_12";


    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (DataBaseConnection dataBaseConnection = new DataBaseConnection()) {
                LessonDao studentDao = new LessonDao(dataBaseConnection.getConnection());
                studentDao.addLesson(new Lesson("test", new Homework(1,"name", "desc")));
                System.out.println(studentDao.getLessons());
                studentDao.deleteLesson(1);
                System.out.println(studentDao.getLessons());
                System.out.println(studentDao.getOneLesson(5));
        }

    }

    public Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed");
    }
}
