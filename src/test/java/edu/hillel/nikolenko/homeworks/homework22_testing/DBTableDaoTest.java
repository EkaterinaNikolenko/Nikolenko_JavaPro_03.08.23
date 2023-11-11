package edu.hillel.nikolenko.homeworks.homework22_testing;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class DBTableDaoTest {
    public final String url = "jdbc:mysql://localhost:3306/testing_database";
    public final String username = "root";
    public final String password = "MySQL_Nikolenko_12";
    private DBTableDao dbtdao;

    @Test
    public void testAddData() throws SQLException {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            dbtdao = new DBTableDao(connection);
            assertEquals(1, dbtdao.addData(new DBTable("1")));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testGetData() {
        try (Connection connection = DriverManager.getConnection(url, username, password)){
            dbtdao = new DBTableDao(connection);
            List<DBTable> list = dbtdao.getData();
            assertNotNull(list);
            assertEquals("1", list.get(0).getSomeData());
            List<DBTable> data = new ArrayList<>();
            try (Statement statement = connection.createStatement()) {
                try (ResultSet resultSet = statement.executeQuery("SELECT * FROM dbtable")) {
                    while (resultSet.next()) {
                        data.add(new DBTable(resultSet.getInt("id"),
                                resultSet.getString("someData")));
                    }
                }
            }
            assertEquals(data.size(), list.size());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
