package edu.hillel.nikolenko.homeworks.homework5_polymorphism.ParticipantsAndBarriers;

public class Treadmill extends Barrier {
    private double distance;

    public Treadmill(double distance) {
        this.distance = distance;
    }

    @Override
    double getDistance() {
        return distance;
    }

    @Override
    boolean overcome() {
        System.out.println("Учасник " + participant.getName() +
                " пройшов бігову доріжку на дистанції " + distance + " метрів");
        return true;
    }

    @Override
    boolean fail() {
        System.out.println("Учасник " + participant.getName() +
                " не пройшов бігову доріжку на дистанції " + distance +
                " метрів. Пройдено " + participant.getLimitLength() + " метрів");
        return false;
    }
}
