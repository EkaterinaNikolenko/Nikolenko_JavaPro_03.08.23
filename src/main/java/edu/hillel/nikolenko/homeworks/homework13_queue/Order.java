package edu.hillel.nikolenko.homeworks.homework13_queue;

public class Order {
    private int number;
    private String name;

    public Order(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return number + " | " + name;
    }
}
