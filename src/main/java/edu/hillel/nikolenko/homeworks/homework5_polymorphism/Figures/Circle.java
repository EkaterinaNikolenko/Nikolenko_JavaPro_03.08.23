package edu.hillel.nikolenko.homeworks.homework5_polymorphism.Figures;

public class Circle implements Figure {
    private double radius;

    private double circleArea;

    public Circle(double radius) {
        this.radius = radius;
        this.circleArea = 2 * Math.PI * radius;
    }

    @Override
    public double getArea() {
        return circleArea;
    }
}
