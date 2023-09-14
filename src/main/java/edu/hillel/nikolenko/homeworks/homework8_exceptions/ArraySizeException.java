package edu.hillel.nikolenko.homeworks.homework8_exceptions;

public class ArraySizeException extends Throwable {
    String message;

    public ArraySizeException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
