package edu.hillel.nikolenko.homeworks.homework20_patterns.factory;

public class FurnitureFactoryImpl implements FurnitureFactory {

    @Override
    public Furniture createFurniture(FurnitureType type) {
        switch (type) {
            case TABLE -> {
                return new Table();
            }
            case CHAIR -> {
                return new Chair();
            }
            case SOFA -> {
                return new Sofa();
            }
        }
        throw new RuntimeException();
    }
}
