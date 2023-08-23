package edu.hillel.nikolenko.homeworks.homework5_polymorphism.ParticipantsAndBarriers;

public class Wall extends Barrier {
    private double distance;

    public Wall(double distance) {
        this.distance = distance;
    }
    @Override
    double getDistance() {
        return distance;
    }
    @Override
    boolean overcome() {
        System.out.println("Учасник " + participant.getName() +
                " пройшов стіну на дистанції " + distance + " метрів");
        return true;
    }

    @Override
    boolean fail() {
        System.out.println("Учасник " + participant.getName() +
                " не пройшов стіну на дистанції " + distance +
                " метрів. Пройдено " + participant.getLimitHeight() + " метрів");
        return false;
    }
}
