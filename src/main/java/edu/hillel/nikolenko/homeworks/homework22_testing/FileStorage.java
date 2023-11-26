package edu.hillel.nikolenko.homeworks.homework22_testing;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class FileStorage implements DataStorage {
    private File datafile = new File("datafile");

    @Override
    public void store(List<String> data) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(datafile, true))) {
            for (String str : data) {
                bw.write(str);
                bw.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public File getDatafile() {
        return datafile;
    }

    public String getPath() {
        return  datafile.getPath();
    }
}
