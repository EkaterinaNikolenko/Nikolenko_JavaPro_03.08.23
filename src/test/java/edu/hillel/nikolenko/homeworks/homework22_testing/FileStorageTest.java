package edu.hillel.nikolenko.homeworks.homework22_testing;

import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class FileStorageTest {
    private FileStorage fs;

    @Before
    public void setUp() {
        fs = new FileStorage();
    }

    @Test
    public void testStore(){
        List<String> data = new ArrayList<>(Arrays.asList("1", "2", "3"));
        fs.store(data);
        List<String> filedata = new ArrayList<>();
        try (BufferedReader fis = new BufferedReader(new FileReader(fs.getPath()))) {
            String line;
            while ((line = fis.readLine()) != null) {
                filedata.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        assertEquals("FileStorage testStore failed", data, filedata);
    }
}
