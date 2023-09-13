package edu.hillel.nikolenko.homeworks.homework9_generics;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Apple apple = new Apple();
        Orange orange = new Orange();

        List<Apple> apples = new ArrayList<>();
        apples.add(apple);
        apples.add(apple);
        apples.add(apple);

        List<Orange> oranges = new ArrayList<>();
        oranges.add(orange);
        oranges.add(orange);
        oranges.add(orange);

        Box<Apple> appleBox = new Box<>();
        Box<Orange> orangeBox = new Box<>();

        appleBox.addOneFruit(apple);
        appleBox.addFruits(apples);
        orangeBox.addOneFruit(orange);
        orangeBox.addFruits(oranges);

        System.out.println(orangeBox.getAmountOfFruits());
        System.out.println(orangeBox.getWeight());
        System.out.println(appleBox.compare(orangeBox));

        Box<Apple> appleBox2 = new Box<>();
        appleBox2.addOneFruit(apple);
        appleBox2.addOneFruit(apple);
        appleBox2.merge(appleBox);

        System.out.println(appleBox.getAmountOfFruits());
        System.out.println(appleBox2.getAmountOfFruits());
        System.out.println(appleBox2.compare(orangeBox));
    }
}
