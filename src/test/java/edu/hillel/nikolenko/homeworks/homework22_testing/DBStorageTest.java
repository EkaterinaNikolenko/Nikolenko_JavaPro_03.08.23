package edu.hillel.nikolenko.homeworks.homework22_testing;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class DBStorageTest {
    private DBTableDao dbtdaoMokcito = Mockito.mock(DBTableDao.class);
    private DBStorage dbs;

    @Before
    public void setUp() {
        dbs = new DBStorage();
        dbs.setDao(dbtdaoMokcito);
    }

    @Test
    public void testStore() throws SQLException{
        List<String> data = new ArrayList<>(Arrays.asList("1", "2", "3"));
        List<DBTable> list = new ArrayList<>(Arrays.asList(new DBTable("1"), new DBTable("2"), new DBTable("3")));
        Mockito.when(dbtdaoMokcito.getData()).thenReturn(new ArrayList<>(list));
        dbs.store(data);
        assertEquals(data.size(), dbtdaoMokcito.getData().size());
    }
}
