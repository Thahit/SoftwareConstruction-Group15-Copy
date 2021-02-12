package com.swcgroup15.assignment4;

import java.util.ArrayList;

public class SectionChief extends RegularEmployee{
    protected ArrayList<Customer> customerList=new ArrayList<>();
    private String city;

    public SectionChief(String name, String surname, String city, DataBase db){// additional info while Constructing
        super(name, surname,  db);

        boolean newCity=db.addCity(city);// better than assigning random city
        if(! newCity){
            throw new java.lang.Error("City already used");
        }
        this.city = city;
    }

    @Override
    public Customer getCustomer(int customerID, DataBase db) {
        for (Customer c : customerList) {
            if (c.getCustomerID() == customerID) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }

    @Override
    public Customer createCustomer(String name, String surname, DataBase db) {// not adding to Custommerlist, because they dont have one
        Customer aCustomer = new Customer(name, surname,  db);
        CreditCard aCreditCard = new CreditCard( db);
        aCustomer.setCreditCard(aCreditCard);
        db.addCustomer(aCustomer);
        aCreditCard.createCustomerData(aCustomer);
        this.customerList.add(aCustomer);
        return  aCustomer;
    }

    @Override
    public void upgrade(int CustomerID, DataBase db) {
        getCustomer(CustomerID,db).getCreditCard().upgrade(getCustomer(CustomerID,db));
    }

    @Override
    public void downgrade(int CustomerID, DataBase db){
        if (getCustomer(CustomerID,db).getCustomerState() == getCustomer(CustomerID,db).getCreditCard().getPlatinumState()){
            System.out.print("Permission denied");
        }
        else {
            getCustomer(CustomerID,db).getCreditCard().downgrade(getCustomer(CustomerID,db));
        }
    }

    //for junit tests only
    public String getEmployeeCity(){
        return this.city;
    }
}