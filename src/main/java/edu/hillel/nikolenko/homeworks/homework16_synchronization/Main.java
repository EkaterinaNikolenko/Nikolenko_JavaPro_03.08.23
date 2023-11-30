package edu.hillel.nikolenko.homeworks.homework16_synchronization;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        PetrolStation petrolStation = new PetrolStation(1000);
        petrolStation.doRefuel(50);
        petrolStation.doRefuel(55);
        petrolStation.doRefuel(45);
        petrolStation.doRefuel(70);
        petrolStation.doRefuel(60);
    }
}
