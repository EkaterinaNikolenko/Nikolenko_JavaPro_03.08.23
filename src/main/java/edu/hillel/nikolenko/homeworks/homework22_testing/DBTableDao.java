package edu.hillel.nikolenko.homeworks.homework22_testing;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBTableDao {
    private Connection connection;

    public DBTableDao(Connection connection) {
        this.connection = connection;
    }

    public int addData(DBTable data) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement
                ("INSERT INTO dbtable (somedata) VALUES (?);")) {
            preparedStatement.setString(1, data.getSomeData());
            return preparedStatement.executeUpdate();
        }
    }

    public List<DBTable> getData() throws SQLException {
        List<DBTable> data = new ArrayList<>();

        try (Statement statement = connection.createStatement()) {
            try (ResultSet resultSet = statement.executeQuery("SELECT * FROM dbtable")) {
                while (resultSet.next()) {
                    data.add(new DBTable(resultSet.getInt("id"),
                            resultSet.getString("someData")));
                }
            }
        }

        return data;
    }
}
