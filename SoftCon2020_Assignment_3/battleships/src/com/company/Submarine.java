package com.company;

import java.util.ArrayList;

public class Submarine extends Observer{
    private static final int length = 3;
    private String img = "[S]";

    public Submarine(String Name){
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