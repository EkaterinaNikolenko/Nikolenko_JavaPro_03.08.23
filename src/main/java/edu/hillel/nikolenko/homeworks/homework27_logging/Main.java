package edu.hillel.nikolenko.homeworks.homework27_logging;

public class Main {
    public static void main(String[] args) {
        Order steve = new Order("Steve");
        Order kim = new Order("Kim");
        Order mark = new Order("Mark");
        Order monica = new Order("Monica");

        CoffeeOrderBoard coffeeOrderBoard = new CoffeeOrderBoard();

        coffeeOrderBoard.add(steve);
        coffeeOrderBoard.add(kim);
        coffeeOrderBoard.add(mark);
        coffeeOrderBoard.add(monica);

        coffeeOrderBoard.draw();
        coffeeOrderBoard.deliver();
        coffeeOrderBoard.draw();

        coffeeOrderBoard.deliver(3);
        coffeeOrderBoard.draw();

    }
}
