package edu.hillel.nikolenko.homeworks.homework5_polymorphism.Figures;

public class Triangle implements Figure {
    private double sideA;
    private double sideB;
    private double sideC;
    private double height;
    private double triangleArea;

    public Triangle(double sideA, double sideB, double sideC) {
        this.sideA = sideA;
        this.sideB = sideB;
        this.sideC = sideC;
        double p = (sideA + sideB + sideC) / 2;
        this.triangleArea = Math.sqrt(p * (p - sideA) * (p - sideB) * (p - sideC));
    }

    public Triangle(double sideA, double height) {
        this.sideA = sideA;
        this.height = height;
        this.triangleArea = sideA * height / 2;
    }

    @Override
    public double getArea() {
        return triangleArea;
    }
}
