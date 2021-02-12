package com.swcgroup15.assignment4;

import java.util.ArrayList;

public class MainChief extends RegularEmployee{
    protected ArrayList<Customer> customerList=new ArrayList<>();
    public MainChief(String name, String surname, DataBase db){
        super(name, surname,  db);
    }

    @Override
    public Customer createCustomer(String name, String surname, DataBase db) {// not adding to Custommerlist, because they dont have one
        Customer aCustomer = new Customer(name, surname,  db);
        CreditCard aCreditCard = new CreditCard(db);
        aCustomer.setCreditCard(aCreditCard);
        db.addCustomer(aCustomer);
        aCreditCard.createCustomerData(aCustomer);
        this.customerList.add(aCustomer);
        return  aCustomer;
    }

    @Override
    public Customer getCustomer(int customerID, DataBase db) {// can work with every customer("not assigned to a city")
        for (Customer c: db.customerList){
            if (c.getCustomerID() ==customerID){
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }

    @Override
    public void upgrade(int customerID, DataBase db) {
        getCustomer(customerID,  db).getCreditCard().upgrade(getCustomer(customerID, db));
    }
    @Override
    public void downgrade(int customerID, DataBase db){
        getCustomer(customerID,db).getCreditCard().downgrade(getCustomer(customerID,db));
    }
}