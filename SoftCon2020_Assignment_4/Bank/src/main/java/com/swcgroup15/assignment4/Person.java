package com.swcgroup15.assignment4;

import java.util.Random;

public abstract class Person {
    protected final String NAME;
    protected final String SURNAME;
    protected final int ID;
    public  Person(String Name, String Surname, DataBase db){
        this.NAME =Name;
        this.SURNAME =Surname;

        // generate ID
        Integer[] id = new Integer[1];
        Random rand = new Random();

        id[0]= rand.nextInt((999 - 100) + 1) + 100;// we decided to use 3 nr ID

        boolean accepted =db.addId(id[0]);
        while (!accepted){
            id[0]= rand.nextInt((999 - 100) + 1) + 100;
            accepted=db.addId(id[0]);
        }
        this.ID =id[0];
    }
}