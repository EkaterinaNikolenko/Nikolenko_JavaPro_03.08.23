package edu.hillel.nikolenko.homeworks.homework10_maven;

import org.example.MathMethods.MathMethods;

public class Main {
    public static void main(String[] args) {
        MathMethods mathMethods = new MathMethods();
        System.out.println(mathMethods.minimum(1, 2));
        System.out.println(mathMethods.maximum(1.0, 2.0));
        System.out.println(mathMethods.squareRoot(4));
        System.out.println(mathMethods.absoluteValue(-20.0));
        System.out.println(mathMethods.addition(5.0f, 3.0f));
        System.out.println(mathMethods.subtraction(5.0f, 3.0f));
        System.out.println(mathMethods.multiplication(5, 3));
        System.out.println(mathMethods.division(15, 3));
    }
}
