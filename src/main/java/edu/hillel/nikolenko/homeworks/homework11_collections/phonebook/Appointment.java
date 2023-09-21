package edu.hillel.nikolenko.homeworks.homework11_collections.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Appointment {
    private String name;
    private List<String> phoneNumber = new ArrayList<>();

    public Appointment(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber.add(phoneNumber);
    }

    public Appointment(String name, List<String> phoneNumber) {
        this.name = name;
        this.phoneNumber.addAll(phoneNumber);
    }

    public void addPhoneNumber(String phone) {
        this.phoneNumber.add(phone);
    }

    public String getName() {
        return name;
    }

    public List<String> getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
