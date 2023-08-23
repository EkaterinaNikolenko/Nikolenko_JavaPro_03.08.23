package edu.hillel.nikolenko.homeworks.homework5_polymorphism.ParticipantsAndBarriers;

public abstract class Barrier {
    Participant participant;

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    abstract boolean overcome();
    abstract boolean fail();
    abstract double getDistance();
}
