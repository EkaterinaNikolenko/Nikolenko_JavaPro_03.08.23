package edu.hillel.nikolenko.homeworks.homework17_iostream;

import java.io.File;
import java.time.LocalDateTime;

public class FileLoggerConfiguration implements LoggerConfiguration {
    private File file;
    private LoggingLevel level;
    public int size;
    private String format;

    public FileLoggerConfiguration(File file, LoggingLevel level, int size) {
        this.file = file;
        this.level = level;
        this.size = size;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = new File(file.toURI());
    }

    public LoggingLevel getLevel() {
        return level;
    }

    public void setLevel(LoggingLevel level) {
        this.level = level;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void setFormat(LocalDateTime time, String message) {
        this.format = "[" + time + "][" + this.level + "] Message: " + message;
    }

    public String getFormat() {
        return format;
    }
}
