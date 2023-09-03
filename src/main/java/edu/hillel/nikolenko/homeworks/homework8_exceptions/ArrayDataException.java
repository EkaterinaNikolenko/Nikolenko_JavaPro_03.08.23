package edu.hillel.nikolenko.homeworks.homework8_exceptions;

public class ArrayDataException extends Throwable {
    String message;

    public ArrayDataException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
