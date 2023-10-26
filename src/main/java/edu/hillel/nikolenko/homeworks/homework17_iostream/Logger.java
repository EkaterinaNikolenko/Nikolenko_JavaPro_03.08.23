package edu.hillel.nikolenko.homeworks.homework17_iostream;

public interface Logger {
    void debug(String message) throws FileMaxSizeReachedException;
    void info(String message) throws FileMaxSizeReachedException;
}
