package edu.hillel.nikolenko.homeworks.homework5_polymorphism.ParticipantsAndBarriers;

import java.util.Random;

public class Robot extends Participant {
    Random rand = new Random();
    private double randLimitLength = rand.nextDouble(1000);
    private double randLimitHeight = rand.nextDouble(1);

    public Robot(String name) {
        super(name);
        System.out.println(name + " length: " + randLimitLength + " height: " + randLimitHeight);
    }

    @Override
    double getLimitLength() {
        return randLimitLength;
    }
    @Override
    double getLimitHeight() {
        return randLimitHeight;
    }
}
