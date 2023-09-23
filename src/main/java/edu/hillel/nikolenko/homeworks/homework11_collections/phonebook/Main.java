package edu.hillel.nikolenko.homeworks.homework11_collections.phonebook;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Appointment steve = new Appointment("Steve", "123456789");
        Appointment mark = new Appointment("Mark", "987654321");

        List<String> kimsPhones = new ArrayList<>();
        kimsPhones.add("246802468");
        kimsPhones.add("135791357");
        Appointment kim = new Appointment("Kim", kimsPhones);

        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add(steve);
        phoneBook.add(mark);
        phoneBook.add(kim);
        phoneBook.add(kim);

        System.out.println(phoneBook.find("Steve"));
        System.out.println(phoneBook.find("Kim"));
        System.out.println(phoneBook.find("SomebodyElse"));
        System.out.println(phoneBook.findAll("Kim"));
        System.out.println(phoneBook.findAll("Mark"));
        System.out.println(phoneBook.findAll("SomebodyElse"));
    }
}
