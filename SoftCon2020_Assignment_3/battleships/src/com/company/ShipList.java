package com.company;

import java.util.ArrayList;

public class ShipList implements List {
    static final int maxShips = 10;
    int numberOfShips=0;
    ArrayList<Ship> ships = new ArrayList<>(10);

    public ShipList(){

        addCarrier("Carrier");
        addBattleship("Battleship1");
        addBattleship("Battleship2");
        addSubmarine("Submarine1");
        addSubmarine("Submarine2");
        addSubmarine("Submarine3");
        addPatrolBoat("PatrolBoat1");
        addPatrolBoat("PatrolBoat2");
        addPatrolBoat("PatrolBoat3");
        addPatrolBoat("PatrolBoat4");
    }

    public void addPatrolBoat(String shipname) {
        PatrolBoat sch = new PatrolBoat(shipname);
        if (numberOfShips >= maxShips) {
            System.err.println("FULL");
        } else {
            ships.add(numberOfShips, sch);
            numberOfShips = numberOfShips+1;
        }
    }
    public void addBattleship(String shipname) {
        Battleship sch = new Battleship(shipname);
        if (numberOfShips >= maxShips) {
            System.err.println("FULL");
        } else {
            ships.add(numberOfShips, sch);
            numberOfShips = numberOfShips+1;
        }
    }
    public void addCarrier(String shipname) {
        Carrier sch = new Carrier(shipname);
        if (numberOfShips >= maxShips) {
            System.err.println("FULL");
        } else {
            ships.add(numberOfShips, sch);
            numberOfShips = numberOfShips+1;
        }
    }
    public void addSubmarine(String shipname) {
        Submarine sch = new Submarine(shipname);
        if (numberOfShips >= maxShips) {
            System.err.println("FULL");
        } else {
            ships.add(numberOfShips, sch);
            numberOfShips = numberOfShips+1;
        }
    }

    public Iterator createIterator(){
        return new ShipIterator(ships);
    }

}
