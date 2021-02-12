package com.company;

import java.util.ArrayList;

class ShipIterator implements Iterator {

    private ArrayList<Ship> ships = new ArrayList<>();
    private int pos = 0;
    //constructor
    public ShipIterator(ArrayList<Ship> ships){

        this.ships = ships;
    }

    public boolean hasNext(){
        if(pos>=ships.size()){
            return false;
        }
        return true;
    }

    public Ship next(){
        Ship ShipPos = ships.get(pos);
        pos = pos + 1;
        return ShipPos;
    }

    public Ship currentShip(){
        Ship currentShipPos = ships.get(pos);
        return currentShipPos;
    }
    public ArrayList<Ship> fullShipList(){
        return ships;
    }
}
