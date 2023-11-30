package edu.hillel.nikolenko.homeworks.homework17_iostream;

public class FileMaxSizeReachedException extends Throwable {
    String message;
    public FileMaxSizeReachedException(String message) {
        this.message = message;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
