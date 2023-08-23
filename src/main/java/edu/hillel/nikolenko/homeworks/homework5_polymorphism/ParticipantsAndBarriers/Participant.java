package edu.hillel.nikolenko.homeworks.homework5_polymorphism.ParticipantsAndBarriers;

public abstract class Participant {
    private String name;

    public Participant(String name) {
        this.name = name;
    }

    private Barrier barrier;

    public boolean run() {
        boolean res;
        System.out.println("Run");
        if(barrier.getDistance() <= getLimitLength()) {
            res = barrier.overcome();
        } else {
            res = barrier.fail();
        }
        return res;
    }

    public boolean jump() {
        boolean res;
        System.out.println("Jump");
        if(barrier.getDistance() <= getLimitHeight()) {
            res = barrier.overcome();
        } else {
            res = barrier.fail();
        }
        return res;
    }

    public void setBarrier(Barrier barrier) {
        this.barrier = barrier;
    }

    public String getName() {
        return name;
    }

    abstract double getLimitLength();
    abstract double getLimitHeight();

}
