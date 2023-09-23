package edu.hillel.nikolenko.homeworks.homework11_collections;

import java.util.Objects;

public class Occurrence {
    private String name;
    private int occurrence = 0;

    public Occurrence(String name) {
        this.name = name;
        this.occurrence = occurrence;
    }
    public Occurrence(String name, int occurrence) {
        this.name = name;
        this.occurrence = occurrence;
    }

    public void increaseOccurrence() {
        this.occurrence += 1;
    }

    public String getName() {
        return name;
    }

    public int getOccurrence() {
        return occurrence;
    }

    @Override
    public String toString() {
        return "{" +
                "name: '" + name + '\'' +
                ", occurrence: " + occurrence +
                '}';
    }

}
