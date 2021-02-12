package com.swcgroup15.assignment4;

import java.util.ArrayList;

public class RegularEmployee extends Person{
    protected ArrayList<Customer> customerList;


    public RegularEmployee(String name, String surname, DataBase db){
        super(name, surname,  db);
        this.customerList = new ArrayList<>();
    }

    public Customer getCustomer(int customerID, DataBase db) {
        for (Customer c : customerList) {
            if (c.getCustomerID() == customerID) {
                return c;
            }
        }
        throw new IllegalArgumentException("Invalid ID");
    }
    public Customer createCustomer(String name, String surname, DataBase db){
        Customer aCustomer = new Customer(name, surname,  db);
        CreditCard aCreditCard = new CreditCard( db);
        aCustomer.setCreditCard(aCreditCard);
        this.customerList.add(aCustomer);
        db.addCustomer(aCustomer);
        aCreditCard.createCustomerData(aCustomer);
        return  aCustomer;
    }

    public void addCustomerToList(Customer aCustomer){//if Customer was to be assigned later
        customerList.add(aCustomer);
    }

    public void upgrade(int CustomerID,DataBase db) {
        if (getCustomer(CustomerID,db).getCustomerState() == getCustomer(CustomerID, db).getCreditCard().getRegularState()){
            getCustomer(CustomerID,db).getCreditCard().upgrade(getCustomer(CustomerID, db)); //follows to the upgrade-method in CreditCard
        } else {
            System.out.print("Permission denied");
        }
    }

    //only made for the purpose of testing
    public void downgrade(int customerID,DataBase db){
        System.out.print("Permission denied");
    }

    //for junit tests only
    public String getEmployeeName(){ return this.NAME;}
    public String getEmployeeSurname(){ return this.SURNAME;}
    public Integer getEmployeeID(){
        return this.ID;
    }
    public ArrayList<Customer> getEmployeeCustomerList(){
        return this.customerList;
    }
}