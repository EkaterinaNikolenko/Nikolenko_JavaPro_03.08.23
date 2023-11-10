package edu.hillel.nikolenko.homeworks.homework20_patterns.factory;

public class Chair extends Furniture {
    @Override
    public void create() {
        System.out.println("Chair was created");
    }
}
