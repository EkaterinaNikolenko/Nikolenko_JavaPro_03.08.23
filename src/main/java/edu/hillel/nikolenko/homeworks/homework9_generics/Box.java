package edu.hillel.nikolenko.homeworks.homework9_generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> box = new ArrayList<>();

    public void addOneFruit(T t) {
        box.add(t);
    }

    public void addFruits(List<T> fruits) {
        box.addAll(fruits);
    }

    public int getAmountOfFruits() {
        return box.size();
    }

    public List<T> getBox() {
        return box;
    }

    public float getWeight() {
        return (float) box.size() * box.get(0).getWeight();
    }

    public boolean compare(Box<? extends Fruit> box) {
        if(getWeight() == box.getWeight()) return true;
        return false;
    }

    public void merge(Box<T> anotherBox) {
        if(this != box) {
            box.addAll(anotherBox.getBox());
        }
        anotherBox.getBox().clear();
    }
}
