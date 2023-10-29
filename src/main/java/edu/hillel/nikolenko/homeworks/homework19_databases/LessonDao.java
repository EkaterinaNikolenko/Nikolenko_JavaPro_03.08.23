package edu.hillel.nikolenko.homeworks.homework19_databases;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LessonDao {
    private Connection connection;

    public LessonDao(Connection connection) {
        this.connection = connection;
    }

    public int addLesson(Lesson lesson) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO lesson (name, homework_id) VALUES (?, ?);")) {
            preparedStatement.setString(1, lesson.getName());
            preparedStatement.setInt(2, lesson.getHomework().getId());
            return preparedStatement.executeUpdate();
        }
    }

    public int deleteLesson(Lesson lesson) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM lesson WHERE id = " + lesson.getId() + ";")) {
            return preparedStatement.executeUpdate();
        }
    }

    public int deleteLesson(int id) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("DELETE FROM lesson WHERE id = " + id + ";")) {
            return preparedStatement.executeUpdate();
        }
    }

    public List<Lesson> getLessons() throws SQLException {
        List<Lesson> lessons = new ArrayList<>();

        Map<Integer, Homework> homeworks = new HashMap<>();
        try (Statement statement = connection.createStatement()) {
            try(ResultSet rs = statement.executeQuery("SELECT * FROM homework;")) {
                while (rs.next()) {
                    homeworks.put(rs.getInt("id"), new Homework(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("description")));
                }
            }
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM lesson;")) {
                while (resultSet.next()) {
                    lessons.add(new Lesson(resultSet.getInt("id"),
                            resultSet.getString("name"),
                            homeworks.get(resultSet.getInt("homework_id"))));
                }
            }
        }
        return lessons;
    }

    public Lesson getOneLesson(int id) throws SQLException {
        Lesson lesson = new Lesson("tx", new Homework("tx", "tx"));
        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM lesson WHERE id = " + id + ";")) {
                resultSet.next();
                lesson = new Lesson(resultSet.getInt("id"),
                        resultSet.getString("name"),
                        new Homework("txt", "txt"));
            }
        }
        return lesson ;
    }
}
