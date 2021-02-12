package com.company;

import java.util.ArrayList;

public class Battleship extends Observer{
    private static final int length = 4;
    private String img = "[B]";

    public Battleship(String Name){
        this.name=Name;
        this.hit = 0;
        this.coordinates = new ArrayList<>();
    }
    public int shipLength(){
        return length;
    }
    public String shipChar(){
        return img;
    }
}
