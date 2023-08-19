package edu.hillel.nikolenko.homeworks.homework4_inheritance;

public class Dog extends Animal {
    static int dogCounter;

    private int length;

    public Dog(String name) {
        super(name);
        dogCounter++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public static int getDogCounter() {
        return dogCounter;
    }

    @Override
    public void run(int length) {
        if(length > 500) {
            System.out.println("The dog can't run that far");
        } else {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        if(length > 10) {
            System.out.println("The dog can't swim that far");
        } else {
            super.swim(length);
        }
    }
}
