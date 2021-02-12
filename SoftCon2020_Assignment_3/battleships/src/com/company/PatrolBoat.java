package com.company;

import java.util.ArrayList;

public class PatrolBoat extends Observer{
    private static final int length = 2;
    private String img = "[P]";

    public PatrolBoat(String Name){
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