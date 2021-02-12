package com.company;

import java.util.ArrayList;

public interface Iterator {
    //iterate over this
    boolean hasNext();

    //return the next element
    Ship next();

    Ship currentShip();
    public ArrayList<Ship> fullShipList();
}
