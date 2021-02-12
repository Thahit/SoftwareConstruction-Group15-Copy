package com.swcgroup15.assignment4;

public class BackendTechnician extends Technician{
    public BackendTechnician(String Name, String Surname, DataBase db){
        super(Name, Surname,  db);
    }
    public void fixBackend(int technicianID){//id never used
        System.out.println("Fixed!");
    }
}
