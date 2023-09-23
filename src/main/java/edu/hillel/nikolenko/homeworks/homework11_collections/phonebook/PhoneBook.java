package edu.hillel.nikolenko.homeworks.homework11_collections.phonebook;

import java.util.ArrayList;
import java.util.List;

public class PhoneBook {
    private List<Appointment> appointmentList = new ArrayList<>();

    public void add(Appointment appointment) {
        appointmentList.add(appointment);
    }

    public Appointment find(String name) {
        for (Appointment appointment : appointmentList) {
            if(appointment.getName() == name) return appointment;
        }
        return null;
    }

    public List<Appointment> findAll(String name) {
        List<Appointment> allAppointments = new ArrayList<>();
        for (Appointment appointment : appointmentList) {
            if(appointment.getName() == name) allAppointments.add(appointment);
        }
        if(allAppointments.size() != 0) {
            return allAppointments;
        } else {
            return null;
        }
    }

    public List<Appointment> getAppointmentList() {
        return appointmentList;
    }
}
