package com.swcgroup15.assignment4;
// does nothing, but is for future extensions
public abstract class Technician extends Person{
    public Technician(String name, String surname, DataBase db){
        super(name, surname,  db);
    }

    //for junit tests only
    public String getTechnicianName(){
        return this.NAME;
    }
    public String getTechnicianSurname(){
        return this.SURNAME;
    }
    public Integer getTechnicianID(){
        return this.ID;
    }
}