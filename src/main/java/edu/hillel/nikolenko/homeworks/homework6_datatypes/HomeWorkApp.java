package edu.hillel.nikolenko.homeworks.homework6_datatypes;

import java.util.Random;

public class HomeWorkApp {
    public static void main(String[] args) {
        int a = rand.nextInt(100) - 50;
        int b = rand.nextInt(100) - 50;
        int year = rand.nextInt(2050);
        int times = rand.nextInt(20);
        String sentence = "Hello world!";

        System.out.println("a: " + a + " b: " + b + " year: " + year + " times " + times);

        printThreeWords();
        checkSumSign();
        printColor();
        compareNumbers();
        System.out.println(belongInterval(a, b));
        checkNumberSign(a);
        System.out.println(isNegative(a));
        writeSeveralTimes(sentence, times);
        System.out.println(isLeapYear(year));
    }
    static Random rand = new Random();
    public static void printThreeWords() {
        System.out.println("Orange");
        System.out.println("Banana");
        System.out.println("Apple");
    }
    public static void checkSumSign() {
        int a = rand.nextInt(200) - 100;
        int b = rand.nextInt(200) - 100;
        int sum = a + b;
        System.out.println("CheckSumSign sum: " + sum);
        if(sum >= 0) {
            System.out.println("The sum is positive");
        } else {
            System.out.println("The sum is negative");
        }
    }
    public static void printColor() {
        int value = rand.nextInt(400) - 200;
        System.out.println("PrintColor value: " + value);
        if(value <= 0) {
            System.out.println("Red");
        } else if(value > 0 && value <= 100) {
            System.out.println("Yellow");
        } else {
            System.out.println("Green");
        }
    }
    public static void compareNumbers() {
        int a = rand.nextInt(100);
        int b = rand.nextInt(100);
        System.out.println("CompareNumbers a: " + a + " b: " + b);
        if(a >= b) {
            System.out.println("a >= b");
        } else {
            System.out.println("a < b");
        }
    }
    public static boolean belongInterval(int a, int b) {
        int sum = a + b;
        System.out.println("BelongInterval sum: " + sum);
        if(sum >= 10 && sum <= 20) {
            return true;
        } else {
            return false;
        }
    }
    public static void checkNumberSign(int a) {
        if(a >= 0) {
            System.out.println("The number is positive");
        } else {
            System.out.println("The number is negative");
        }
    }
    public static boolean isNegative(int a) {
        if(a < 0) {
            return true;
        } else {
            return false;
        }
    }
    public static void writeSeveralTimes(String sen, int num) {
        for (int i = 0; i <= num; i++) {
            System.out.println(sen);
        }
    }
    public static boolean isLeapYear(int year) {
        if(year % 4 == 0) {
            if(year % 400 == 0) {
                return true;
            } else if(year % 100 == 0) {
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
