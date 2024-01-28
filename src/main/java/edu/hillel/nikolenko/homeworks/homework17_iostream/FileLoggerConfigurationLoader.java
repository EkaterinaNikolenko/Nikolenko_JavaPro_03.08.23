package edu.hillel.nikolenko.homeworks.homework17_iostream;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileLoggerConfigurationLoader implements LoggerConfigurationLoader {

    public FileLoggerConfiguration load(FileLoggerConfiguration fileLoggerConfiguration) {
        File file = new File("Load_" + fileLoggerConfiguration.getFile().getName());
        try (BufferedWriter fis = new BufferedWriter(new FileWriter(file, true))) {
            fis.write("FILE: " + fileLoggerConfiguration.getFile().getPath() + "\n");
            fis.write("LEVEL: " + fileLoggerConfiguration.getLevel() + "\n");
            fis.write("MAX-SIZE: " + fileLoggerConfiguration.getSize() + "\n");
            fis.write("FORMAT: " + fileLoggerConfiguration.getFormat() + "\n");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileLoggerConfiguration f = new FileLoggerConfiguration(file, LoggingLevel.INFO, 100);
        return f;
    }
}
