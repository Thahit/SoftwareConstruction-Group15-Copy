package com.swcgroup15.assignment4;

public class WebTechnician extends Technician{
    public WebTechnician(String name, String surname, DataBase db){
        super(name, surname,  db);
    }
    public void fixWebsite(){
        int secondsToSleep=30;
            try {
        Thread.sleep(secondsToSleep * 1000);
    } catch (InterruptedException ie) {
        Thread.currentThread().interrupt();
        }
            System.out.println("reparations complete");
    }
}