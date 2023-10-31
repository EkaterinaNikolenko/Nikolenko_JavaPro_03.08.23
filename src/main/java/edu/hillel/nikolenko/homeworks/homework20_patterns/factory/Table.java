package edu.hillel.nikolenko.homeworks.homework20_patterns.factory;

public class Table extends Furniture {
    @Override
    public void create() {
        System.out.println("Table was created");
    }
}
