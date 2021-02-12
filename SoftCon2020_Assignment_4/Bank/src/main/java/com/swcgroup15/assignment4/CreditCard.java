package com.swcgroup15.assignment4;

import java.util.Hashtable;
import java.util.Random;

public class CreditCard {
    private Hashtable ownerInfo =new Hashtable<>();
    private String serialNr;
    private int securityCode;    //unused
    private String expDate;    //unused
    private State currentState;
    private final State REGULARSTATE;
    private final State GOLDENSTATE;
    private final State PLATINUMSTATE;

    public CreditCard(DataBase db) {
        this.REGULARSTATE = new RegularState();
        this.GOLDENSTATE = new GoldenState(); // otherwise we would have to use setter
        this.PLATINUMSTATE = new PlatinumState(); // otherwise we would have to use setter
        this.currentState = REGULARSTATE;
        Random rand = new Random();
        this.securityCode =rand.nextInt((999 - 100) + 1) + 100;;   //does not have to be unique
        this.expDate = "9.11.2022";//arbitrary


        // generate serial nr.
        String[] serial = new String[1];
        serial[0]= "1111"+Integer.toString(rand.nextInt(9999 - 1000) + 1000)+Integer.toString(rand.nextInt(9999 - 1000) + 1000)+Integer.toString(rand.nextInt(9999 - 1000) + 1000);
        boolean accepted =db.addSerial(serial[0]);
        while (!accepted){
            serial[0]= "1111"+Integer.toString(rand.nextInt(9999 - 1000) + 1000)+Integer.toString(rand.nextInt(9999 - 1000) + 1000)+Integer.toString(rand.nextInt(9999 - 1000) + 1000);
            accepted=db.addSerial(serial[0]);
        }
        this.serialNr =serial[0];
    }
    public void createCustomerData(Customer owner){
        ownerInfo.put("ID",owner.ID);
        ownerInfo.put("Surname",owner.SURNAME);
        ownerInfo.put("Name",owner.NAME);
    }

    public void useCreditCard(float bill){
        getCurrentState().useCreditCard(bill);
    }
    public void upgrade(Customer customer) {
        this.currentState = customer.getCustomerState().upgrade(customer);
    }
    public void downgrade(Customer customer){
        this.currentState = customer.getCustomerState().downgrade(customer);
    }

    public State getCurrentState(){
        return this.currentState;
    }
    public State getRegularState(){
        return this.REGULARSTATE;
    }
    public State getGoldenState(){
        return this.GOLDENSTATE;
    }
    public State getPlatinumState(){
        return this.PLATINUMSTATE;
    }

    //for junit tests only
    public String getCreditcardSerial(){
        return this.serialNr;
    }

}