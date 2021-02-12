package com.swcgroup15.assignment4;

public class GoldenState implements State{
    private final int LIMIT = 5000;

    @Override
    public void useCreditCard(float bill) {
        if (bill>LIMIT|| bill<0){
            System.out.println("Creditcard: *declined*");
        }
        else{
            System.out.println("Bill successfully paid");
        }
    }
    public State upgrade(Customer customer){
        return customer.getCreditCard().getPlatinumState();
    }
    public State downgrade(Customer customer){
        return customer.getCreditCard().getRegularState();
    }
}