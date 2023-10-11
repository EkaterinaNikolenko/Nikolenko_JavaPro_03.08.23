package edu.hillel.nikolenko.homeworks.homework15_multithreading;

public class ValueCalculator {
    private int length;
    private int halfLength;
    private float[] numbers;
    private float[] num1;
    private float[] num2;

    public ValueCalculator(int length) {
        this.length = length;
        this.halfLength = length / 2;
        this.numbers = new float[length];
        this.num1 = new float[halfLength];
        this.num2 = new float[halfLength];
    }

    public void method() {
        long start = System.currentTimeMillis();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i]  = 1.0f;
        }

        System.arraycopy(numbers, 0, num1, 0, halfLength);
        System.arraycopy(numbers, halfLength, num2, 0, halfLength);

        new Thread(() -> {
            for (int i = 0; i < num1.length; i++) {
                num1[i] = (float)(numbers[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5 * Math.cos(0.4f + i / 2)));
            }
        }).start();

        for (int i = 0; i < num2.length; i++) {
            num2[i] = (float)(numbers[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5 * Math.cos(0.4f + i / 2)));
        }

        System.arraycopy(num1, 0, numbers, 0, halfLength);
        System.arraycopy(num2, 0, numbers, halfLength, halfLength);

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }

        long end = System.currentTimeMillis();

        System.out.println("Spent time: "+ (end - start) + " milliseconds");
    }

    public int getLength() {
        return length;
    }

    public int getHalfLength() {
        return halfLength;
    }

    public float[] getNumbers() {
        return numbers;
    }

    public float[] getNum1() {
        return num1;
    }

    public float[] getNum2() {
        return num2;
    }
}
