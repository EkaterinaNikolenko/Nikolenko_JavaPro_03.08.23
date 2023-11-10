package edu.hillel.nikolenko.homeworks.homework20_patterns.strategy;

public class Main {
    public static void main(String[] args) {
        Context context;

        context = new Context(new Rectangle(3.0, 4.0));
        System.out.println("Rectangle's area: " + context.executeAreaStrategy());

        context = new Context(new Triangle(5.0, 3.0));
        System.out.println("Triangle's area: " + context.executeAreaStrategy());
    }
}
