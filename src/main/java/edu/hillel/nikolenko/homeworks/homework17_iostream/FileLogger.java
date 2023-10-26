package edu.hillel.nikolenko.homeworks.homework17_iostream;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

public class FileLogger implements Logger{
    FileLoggerConfiguration fileLoggerConfiguration;
    public FileLogger(FileLoggerConfiguration fileLoggerConfiguration) {
        this.fileLoggerConfiguration = fileLoggerConfiguration;
    }

    public void debug(String message) throws FileMaxSizeReachedException {
        fileLoggerConfiguration.setLevel(LoggingLevel.DEBUG);
        final LocalDateTime time = LocalDateTime.now();
        if(fileLoggerConfiguration.getFile().length() < fileLoggerConfiguration.getSize()) {
            fileLoggerConfiguration.setFormat(time, message);
            try (PrintWriter w = new PrintWriter(new FileWriter(fileLoggerConfiguration.getFile(), true))) {
                w.println(fileLoggerConfiguration.getFormat());
                System.out.println(fileLoggerConfiguration.getFormat());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
//            throw new FileMaxSizeReachedException("Max size: " + fileLoggerConfiguration.getSize() +
//                    "; File size: " + fileLoggerConfiguration.getFile().length() +
//                    "; File path: " + fileLoggerConfiguration.getFile().getPath());
            File newFile = new File("Log_" + time.getNano() + ".txt");
        }
    }

    public void info(String message) throws FileMaxSizeReachedException {
        fileLoggerConfiguration.setLevel(LoggingLevel.INFO);
        final LocalDateTime time = LocalDateTime.now();
        if(fileLoggerConfiguration.getFile().length() < fileLoggerConfiguration.getSize()) {
            fileLoggerConfiguration.setFormat(time, message);
            try (PrintWriter w = new PrintWriter(new FileWriter(fileLoggerConfiguration.getFile(), true))) {
                w.println(fileLoggerConfiguration.getFormat());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } else {
//            throw new FileMaxSizeReachedException("Max size: " + fileLoggerConfiguration.getSize() +
//                    "; File size: " + fileLoggerConfiguration.getFile().length() +
//                    "; File path: " + fileLoggerConfiguration.getFile().getPath());
            File newFile = new File("Log_" + time.getNano() + ".txt");
            fileLoggerConfiguration.setFile(newFile);
        }
    }

}
