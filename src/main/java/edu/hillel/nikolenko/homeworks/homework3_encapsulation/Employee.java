package edu.hillel.nikolenko.homeworks.homework3_encapsulation;

public class Employee {
    private String name;
    private String surname;
    private String job;
    private String email;
    private String phoneNumber;
    private int age;
    public Employee(String name, String surname, String job, String email, String phoneNumber, int age) {
        this.name = name;
        this.surname = surname;
        this.job = job;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getJob() {
        return job;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", job='" + job + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", age=" + age +
                '}';
    }
}
