package edu.hillel.nikolenko.homeworks.homework12_dictionary;

public class FilePathException extends Throwable {
    String message;

    public FilePathException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
