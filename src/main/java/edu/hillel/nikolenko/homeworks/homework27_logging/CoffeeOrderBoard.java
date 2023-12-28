package edu.hillel.nikolenko.homeworks.homework27_logging;

import org.apache.log4j.Logger;

import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;

public class CoffeeOrderBoard {
    private static final Logger logger = Logger.getLogger(CoffeeOrderBoard.class);

    private Queue<Order> orders = new LinkedList<>();

    private int nextOrderNumber = 1;

    public void add(Order order) {
        orders.add(order);
        order.setNumber(nextOrderNumber);
        nextOrderNumber++;
        logger.info("Order added: " + order);
    }

    public void deliver() {
        try {
            Order order = orders.remove();
            logger.info("The closest order delivered: " + order);
        } catch (NoSuchElementException e) {
            logger.error("Failed to deliver order: no orders in the queue", e);
        }
    }

    public void deliver(int orderNumber) {
        for (Order order : orders) {
            if(order.getNumber() == orderNumber) {
                orders.remove(order);
                logger.info("Order delivered by order number: " + order);
                return;
            }
        }
        IllegalArgumentException e = new IllegalArgumentException("Order number " + orderNumber + " not found");
        logger.error("Failed to deliver order", e);
    }

    public void draw() {
        logger.info("Drawing order board");
        System.out.println("Num | Name");
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    public Queue<Order> getOrders() {
        return orders;
    }
}
