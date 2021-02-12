package com.companyFirstExercise;

public class EmployeeModel {
    private String name;
    private String surname;
    private String ID;
    private String address;
    private String phoneNumber;

    public String getName(){
        return name;
    }
    public String getSurname(){
        return surname;
    }
    public String getID(){
        return ID;
    }
    public String getAddress(){
        return address;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public void setName(String name){
        this.name = name;
    }
    public void setSurname(String surname){
        this.surname = surname;
    }
    public void setID(String ID){
        this.ID = ID;
    }
    public  void setAddress(String address){
        this.address = address;
    }
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }
}
