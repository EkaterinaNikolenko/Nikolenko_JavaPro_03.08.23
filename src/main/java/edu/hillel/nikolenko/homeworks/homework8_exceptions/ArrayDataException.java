package edu.hillel.nikolenko.homeworks.homework8_exceptions;

public class ArrayDataException extends Throwable {
    private String message;
    private Throwable e;

    public ArrayDataException(String s, Throwable e) {
        this.message = s;
        this.e = e;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public Throwable getE() {
        return e;
    }
}
