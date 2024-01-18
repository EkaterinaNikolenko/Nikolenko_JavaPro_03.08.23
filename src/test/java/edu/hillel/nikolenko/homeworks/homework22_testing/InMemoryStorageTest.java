package edu.hillel.nikolenko.homeworks.homework22_testing;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class InMemoryStorageTest {
    private InMemoryStorage ims;

    @Before
    public void setUp() {
        ims = new InMemoryStorage();
    }

    @Test
    public void testStore() {
        List<String> data = new ArrayList<>(Arrays.asList("1", "2", "3"));
        ims.store(data);
        assertEquals("InMemoryStorage testStore failed",3, ims.getListSize());
    }
}
