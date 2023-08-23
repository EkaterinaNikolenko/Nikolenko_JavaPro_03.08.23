package edu.hillel.nikolenko.homeworks.homework5_polymorphism.Figures;

public class Square implements Figure {
    private double side;
    private double squareArea;

    public Square(double side) {
        this.side = side;
        this.squareArea = Math.pow(side, 2);
    }

    @Override
    public double getArea() {
        return squareArea;
    }
}
