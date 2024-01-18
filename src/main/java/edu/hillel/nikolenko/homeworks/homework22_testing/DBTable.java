package edu.hillel.nikolenko.homeworks.homework22_testing;

public class DBTable {
    private int id;
    private String someData;

    public DBTable(String someData) {
        this.someData = someData;
    }

    public DBTable(int id, String someData) {
        this.id = id;
        this.someData = someData;
    }

    public int getId() {
        return id;
    }

    public String getSomeData() {
        return someData;
    }
}
