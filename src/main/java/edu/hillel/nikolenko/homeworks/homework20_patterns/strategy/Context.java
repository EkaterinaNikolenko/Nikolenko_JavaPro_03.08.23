package edu.hillel.nikolenko.homeworks.homework20_patterns.strategy;

public class Context {
    private AreaStrategy areaStrategy;

    public Context (AreaStrategy areaStrategy) {
        this.areaStrategy = areaStrategy;
    }

    public double executeAreaStrategy() {
        return areaStrategy.calculateArea();
    }
}
