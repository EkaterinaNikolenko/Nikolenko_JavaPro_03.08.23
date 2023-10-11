package edu.hillel.nikolenko.homeworks.homework16_synchronization;

import java.util.concurrent.*;

public class PetrolStation {
    private double amount;

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public PetrolStation(double amount) {
        this.amount = amount;
    }

    public void doRefuel(double amount) {
            final Future<Double> future = executorService.submit(() -> {
                try {
                    Thread.sleep((long) ((Math.random() * (10 - 3) + 3) * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(this.amount - amount >= 0) {
                    this.amount -= amount;
                    System.out.println("Amount of fuel: " + this.amount);
                } else {
                    System.out.println("Fuel ran out");
                }
                return this.amount;
            });
    }

    public double getAmount() {
        return amount;
    }
}
