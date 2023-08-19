package edu.hillel.nikolenko.homeworks.homework4_inheritance;

public class Main {
    public static void main(String[] args) {
        Dog dogBobik = new Dog("Bobik");
        Dog dogSharik = new Dog("Sharik");
        dogBobik.run(150);
        dogSharik.run(1000);
        dogBobik.swim(15);
        dogSharik.swim(10);

        Cat catBarsik = new Cat("Barsik");
        catBarsik.run(100);
        catBarsik.swim(50);
        catBarsik.run(250);

        Animal bear = new Animal("Baloo");
        bear.swim(200);
        Animal monkey = new Animal("Monkey");
        monkey.run(120);

        System.out.println("Total number of animals: " + Animal.animalCounter);
        System.out.println("Total number of cats: " + Cat.catCounter);
        System.out.println("Total number of dogs: " + Dog.dogCounter);
    }
}
