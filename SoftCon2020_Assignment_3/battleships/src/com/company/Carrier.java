package com.company;

import java.util.ArrayList;

public class Carrier extends Observer{
    private static final int length = 6;
    private String img = "[C]";

    public Carrier(String Name){
        this.name=Name;
        this.hit=0;
        this.coordinates = new ArrayList<>();
    }
    public int shipLength(){
        return length;
    }
    public String shipChar(){
        return img;
    }
}
