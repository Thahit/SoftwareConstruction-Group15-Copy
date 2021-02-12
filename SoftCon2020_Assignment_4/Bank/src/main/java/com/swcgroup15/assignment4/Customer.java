package com.swcgroup15.assignment4;

import java.util.Random;

public class Customer extends Person{
    private int age;    //useless
    private int bankNr; //useless
    private float savings;
    private CreditCard creditCard;

    public Customer(String name, String surname, DataBase db){
        super(name, surname,  db);
        Random rand = new Random();
        int age= rand.nextInt(100-18)+18;//assuming Customer's Age is between 18 and 100
        this.age =age;
        this.bankNr = ID;
    }

    public void deposit(float amount){
        if (amount >0){
            this.savings += amount;
            System.out.println("*Deposits Money*");
        }else{
            System.out.println("*Illegal Input*");
        }
    }
    public void withdraw(float amount){
        if (this.savings >= amount && amount >0){
            this.savings -=amount;
            System.out.println("*Withdraws Money*");
        }
        else {
            System.out.println("*Failed to withdraw Money*");
        }
    }

    public void useCreditCard(float bill){//checked for negaative input in states
        getCreditCard().useCreditCard(bill);
    }
    public void bankTransfer(float amount){
        if (this.savings >= amount &&amount >0){
            this.savings -=amount;
            System.out.println("*Pays With Savings*");
        }
        else {
            System.out.println("*Fails to pay With Savings*");
        }
    }

    public int getCustomerID(){
        return this.ID;
    }
    public CreditCard setCreditCard(CreditCard aCreditCard){
        return this.creditCard = aCreditCard;
    }
    public CreditCard getCreditCard(){
        return this.creditCard;
    }
    public State getCustomerState(){
        return this.getCreditCard().getCurrentState();
    }

    //for junit tests only
    public String getCustomerName(){ return this.NAME;}
    public String getCustomerSurname(){ return this.SURNAME;}
    public Integer getCustomerAge(){ return this.age;}
    public Integer getCustomerBankNr(){
        return this.bankNr;
    }
}