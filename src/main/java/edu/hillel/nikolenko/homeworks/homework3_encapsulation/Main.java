package edu.hillel.nikolenko.homeworks.homework3_encapsulation;

public class Main {
    public static void main(String[] args) {
        Employee employee = new Employee("Steve", "Jackson", "Java Developer", "steve@gmail.com", "1234567890", 25);
        System.out.println(employee);

        Car car = new Car();
        car.start();
    }
}
