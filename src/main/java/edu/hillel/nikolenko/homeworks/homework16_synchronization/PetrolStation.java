package edu.hillel.nikolenko.homeworks.homework16_synchronization;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReference;

public class PetrolStation {
    private AtomicReference<Double> amount;

    private final ExecutorService executorService = Executors.newFixedThreadPool(3);

    public PetrolStation(double amount) {
        this.amount = new AtomicReference<Double>(amount);
    }

    public void doRefuel(double amount) {
            final Future<AtomicReference<Double>> future = executorService.submit(() -> {
                try {
                    Thread.sleep((long) ((Math.random() * (10 - 3) + 3) * 1000));
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                if(this.amount.get() - amount >= 0) {
                    this.amount.set(this.amount.get() - amount);
                    System.out.println("Amount of fuel: " + this.amount);
                } else {
                    System.out.println("Fuel ran out");
                }
                return this.amount;
            });
    }

    public AtomicReference<Double> getAmount() {
        return amount;
    }
}
