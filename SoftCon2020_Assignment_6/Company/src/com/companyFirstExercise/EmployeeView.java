package com.companyFirstExercise;

public class EmployeeView {
    public void printNameAndID(String name, String surname, String ID){
        System.out.println("Name: "+name);
        System.out.println("Surname: "+surname);
        System.out.println("ID "+ID);
    }
    public void printAddress(String address){
        System.out.println("Address: "+address);
    }
    public void printPhoneNumber(String phoneNumber){
        System.out.println("Phonenumber: "+phoneNumber+"\n");
    }
}
