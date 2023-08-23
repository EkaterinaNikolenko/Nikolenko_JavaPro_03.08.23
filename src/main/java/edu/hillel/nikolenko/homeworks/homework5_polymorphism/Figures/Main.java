package edu.hillel.nikolenko.homeworks.homework5_polymorphism.Figures;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static double summaryOfAreas(List<Figure> figures) {
        double sum = 0;
        for(Figure figure : figures) {
            System.out.println(figure.getArea());
            sum += figure.getArea();
        }
        return sum;
    }
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        Square square = new Square(10);
        Triangle triangle1 = new Triangle(5, 12, 13);
        Triangle triangle2 = new Triangle(24, 5);

        List<Figure> figures = new ArrayList<>();
        figures.add(circle);
        figures.add(square);
        figures.add(triangle1);
        figures.add(triangle2);

        System.out.println(summaryOfAreas(figures));
    }
}
