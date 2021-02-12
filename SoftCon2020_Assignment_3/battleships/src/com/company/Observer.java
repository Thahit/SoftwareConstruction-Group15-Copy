package com.company;

import java.util.ArrayList;
/*
 *this abstract class is a blueprint for all ships. Consequently, all ships are Observers of Playable and Opponent
 */

public abstract class Observer implements Ship {
   //following variables will be defined by each ship-class
    private static int length;
    private String img;

    //following variables will be defined by each ship's constructor
    protected ArrayList<String> coordinates;
    protected int hit;
    protected String name;

    //explained in the interface "ship"
    public boolean update(Ship s){
        this.hit++;
        if(this.hit==s.shipLength()){
            return true;
        }
        return false;
    }

    public String Name(){
        return this.name;
    }

    public ArrayList getCoordinates(){ return this.coordinates;}

    public abstract int shipLength();

    public abstract String shipChar();
}