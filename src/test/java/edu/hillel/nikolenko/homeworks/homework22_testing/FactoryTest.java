package edu.hillel.nikolenko.homeworks.homework22_testing;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class FactoryTest {
    private Factory factory;

    @Before
    public void setUp() {
        factory = new Factory();
    }

    @Test
    public void testCreateStorageInMemory() {
        assertEquals(InMemoryStorage.class, factory.createStorage(StorageType.IN_MEMORY).getClass());
    }

    @Test
    public void testCreateStorageFile() {
        assertEquals(FileStorage.class, factory.createStorage(StorageType.FILE).getClass());
    }

    @Test
    public void testCreateStorageDB() {
        assertEquals(DBStorage.class, factory.createStorage(StorageType.DB).getClass());
    }
}
