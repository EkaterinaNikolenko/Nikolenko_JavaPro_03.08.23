package edu.hillel.nikolenko.homeworks.homework4_inheritance;

public class Animal {
    static int animalCounter;

    private String name;

    public Animal(String name) {
        this.name = name;
        animalCounter++;
    }

    public String getName() {
        return name;
    }

    public static int getAnimalCounter() {
        return animalCounter;
    }

    public void swim(int length) {
        System.out.println(this.name + " swam " + length + "m");
    }
    public void run(int length) {
        System.out.println(this.name + " ran " + length + "m");
    }

}
