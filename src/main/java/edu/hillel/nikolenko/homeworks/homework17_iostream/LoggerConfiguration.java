package edu.hillel.nikolenko.homeworks.homework17_iostream;

import java.io.File;
import java.time.LocalDateTime;

public interface LoggerConfiguration {
    File getFile();
    void setFile(File file);
    LoggingLevel getLevel();
    void setLevel(LoggingLevel level);
    void setSize(int size);
    void setFormat(LocalDateTime time, String message);
    String getFormat();
}
