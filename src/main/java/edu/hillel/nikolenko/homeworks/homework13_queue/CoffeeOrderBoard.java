package edu.hillel.nikolenko.homeworks.homework13_queue;

import java.util.LinkedList;
import java.util.Queue;

public class CoffeeOrderBoard {
    private Queue<Order> orders = new LinkedList<>();

    private int nextOrderNumber = 1;

    public void add(Order order) {
        orders.add(order);
        order.setNumber(nextOrderNumber);
        nextOrderNumber++;
    }

    public void deliver() {
        orders.remove();
    }

    public void deliver(int orderNumber) {
        for (Order order : orders) {
            if(order.getNumber() == orderNumber) {
                orders.remove(order);
            }
        }
    }

    public void draw() {
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public Queue<Order> getOrders() {
        return orders;
    }
}
