package edu.hillel.nikolenko.homeworks.homework22_testing;

import java.util.ArrayList;
import java.util.List;

public class InMemoryStorage implements DataStorage {
    private List<String> datalist = new ArrayList<>();
    @Override
    public void store(List<String> data) {
        datalist.addAll(data);
    }

    public List<String> getDatalist() {
        return datalist;
    }

    public int getListSize() {
        return datalist.size();
    }
}
