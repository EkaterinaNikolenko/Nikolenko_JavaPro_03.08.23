package edu.hillel.nikolenko.homeworks.homework19_databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseConnection {

    public static final String url = "jdbc:mysql://localhost:3306/hw19_schema";
    public static final String username = "root";
    public static final String password = "MySQL_Nikolenko_12";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection connection = getConnection();
        try {
            LessonDao studentDao = new LessonDao(connection);
            studentDao.addLesson(new Lesson("test", new Homework(1,"name", "desc")));
            System.out.println(studentDao.getLessons());
            studentDao.deleteLesson(1);
            System.out.println(studentDao.getLessons());
            System.out.println(studentDao.getOneLesson(5));
        } finally {
            close(connection);
        }

    }

    public static Connection getConnection() {
        Connection connection;
        try {
            connection = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }

    public static void close(Connection connection) {
        if(connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
