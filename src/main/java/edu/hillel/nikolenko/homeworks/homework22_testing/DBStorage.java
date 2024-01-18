package edu.hillel.nikolenko.homeworks.homework22_testing;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DBStorage implements DataStorage {
    private DBTableDao dao;

    @Override
    public void store(List<String> data) {
        for (String str : data) {
            try {
                dao.addData(new DBTable(str));
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public DBTableDao getDao() {
        return dao;
    }

    public void setDao(DBTableDao dao) {
        this.dao = dao;
    }
}
