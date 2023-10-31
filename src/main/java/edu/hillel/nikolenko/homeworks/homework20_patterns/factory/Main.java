package edu.hillel.nikolenko.homeworks.homework20_patterns.factory;

public class Main {
    public static void main(String[] args) {
        FurnitureFactoryImpl factory = new FurnitureFactoryImpl();
        factory.createFurniture(FurnitureType.TABLE).create();
        factory.createFurniture(FurnitureType.CHAIR).create();
        factory.createFurniture(FurnitureType.SOFA).create();
    }
}
