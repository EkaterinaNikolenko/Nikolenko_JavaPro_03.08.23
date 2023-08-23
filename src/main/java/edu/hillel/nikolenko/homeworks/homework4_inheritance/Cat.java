package edu.hillel.nikolenko.homeworks.homework4_inheritance;

public class Cat extends Animal {
    static int catCounter;

    private int length;
    public Cat(String name) {
        super(name);
        catCounter++;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public void run(int length) {
        if(length > 200) {
            System.out.println("The cat can't run that far");
        } else {
            super.run(length);
        }
    }

    @Override
    public void swim(int length) {
        System.out.println("The cat can't swim");
    }
}
