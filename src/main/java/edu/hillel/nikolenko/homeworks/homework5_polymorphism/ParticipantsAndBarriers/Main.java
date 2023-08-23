package edu.hillel.nikolenko.homeworks.homework5_polymorphism.ParticipantsAndBarriers;

import edu.hillel.nikolenko.homeworks.homework5_polymorphism.Figures.Figure;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void startGame(List<Participant> participants, List<Barrier> barriers) {
        for(Participant participant : participants) {
            for(Barrier barrier : barriers) {
                boolean passed = false;
                participant.setBarrier(barrier);
                barrier.setParticipant(participant);
                if(barrier instanceof Wall) {
                    passed = participant.jump();
                } else if (barrier instanceof Treadmill) {
                    passed = participant.run();
                }
                if(!passed) {
                    System.out.println("Учасник " + participant.getName() + " вибув");
                    break;
                }
            }
        }
    }
    public static void main(String[] args) {
        Person person = new Person("Джек");
        Cat cat = new Cat("Барсік");
        Robot robot = new Robot("Робот");
        Treadmill treadmill = new Treadmill(200);
        Wall wall = new Wall(0.5);

        List<Participant> participants = new ArrayList<>();
        List<Barrier> barriers = new ArrayList<>();

        participants.add(person);
        participants.add(cat);
        participants.add(robot);
        barriers.add(treadmill);
        barriers.add(wall);

        startGame(participants, barriers);
    }
}
