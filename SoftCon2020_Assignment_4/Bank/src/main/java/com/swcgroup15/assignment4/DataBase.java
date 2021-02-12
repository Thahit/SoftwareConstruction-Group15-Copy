package com.swcgroup15.assignment4;

import java.util.ArrayList;

public class DataBase {
    // a Database was the cleanest idea we had to make sure everything that should be unique, is unique
    protected   ArrayList<Integer> idList=new ArrayList<>();
    protected   ArrayList<String> seriallist =new ArrayList<>();
    protected   ArrayList<Customer> customerList =new ArrayList<>();
    protected   ArrayList<String> cityBase =new ArrayList<>();

    //singleton if needed
    private volatile static DataBase dataBase;
    private DataBase() {}
    public static DataBase DataBase() {
        if (dataBase == null) {
            synchronized (DataBase.class) {
                if (dataBase == null) {
                    dataBase = new DataBase();
                }
            }
        }
        return dataBase;
    }
    public  boolean addId(Integer id){
            if (this.idList.contains(id)) {
                return false;
            } else {
                this.idList.add(id);
                return true;
            }
        }

    public  boolean addSerial(String serialNr){
        if (this.seriallist.contains(serialNr)) {
            return false;
        } else {
            this.seriallist.add(serialNr);
            return true;
        }
    }
    public void addCustomer(Customer c){
        this.customerList.add(c);
    }
    public  boolean addCity(String city){
        if (this.cityBase.contains(city)) {
            return false;
        } else {
            this.cityBase.add(city);
            return true;
        }
    }
    public void clearDb(){
        this.idList =new ArrayList<>();
        this.seriallist =new ArrayList<>();
        this.customerList =new ArrayList<>();
        this.cityBase =new ArrayList<>();
    }
}