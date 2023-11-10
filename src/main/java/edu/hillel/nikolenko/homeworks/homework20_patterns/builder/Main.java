package edu.hillel.nikolenko.homeworks.homework20_patterns.builder;

public class Main {
    public static void main(String[] args) {
        final Car car1 = Car.newBuilder().body("sedan").engine("diesel").transmission("manual").seats(4).build();
        final Car car2 = Car.newBuilder().body("crossover").engine("petrol").transmission("auto").seats(5).navigator("navigator").build();
    }
}
