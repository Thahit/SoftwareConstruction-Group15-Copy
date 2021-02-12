package com.swcgroup15.assignment4;

public class PlatinumState implements State{
    private final int LIMIT = 10000;

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
        throw new IllegalCallerException("Customer's status is already Platinum");
    }
    public State downgrade(Customer customer){
        return customer.getCreditCard().getGoldenState();
    }
}
