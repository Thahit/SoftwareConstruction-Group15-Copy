package com.companyFirstExercise;

public class EmployeeController {
    private EmployeeModel model;
    private EmployeeView view;

    public EmployeeController(EmployeeModel model, EmployeeView view){
        this.model = model;
        this.view = view;
    }

    public String getName(){
        return model.getName();
    }
    public String getSurname(){
        return model.getSurname();
    }
    public String getID(){
        return model.getID();
    }
    public String getAddress(){
        return model.getAddress();
    }
    public String getPhoneNumber(){
        return model.getPhoneNumber();
    }
    public void setName(String name){
        model.setName(name);
    }
    public void setSurname(String surname){
        model.setSurname(surname);
    }
    public void setID(String ID){
        model.setID(ID);
    }
    public  void setAddress(String address){
        model.setAddress(address);
    }
    public void setPhoneNumber(String phoneNumber){
        model.setPhoneNumber(phoneNumber);
    }

    public void updateView(){
        view.printNameAndID(model.getName(),model.getSurname(),model.getID());
        view.printAddress(model.getAddress());
        view.printPhoneNumber(model.getPhoneNumber());
    }
}
