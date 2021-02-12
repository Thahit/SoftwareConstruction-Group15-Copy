package com.companyFirstExercise;

public class MVCPatternDemo {
    public static void main(String[] args) {
        //get Initial employee
        EmployeeModel model = generateEmployeeFromTheVoid();

        //creating userInterface/view
        EmployeeView view = new EmployeeView();

        //creating controller

        EmployeeController controller = new EmployeeController(model, view);
        System.out.println("Initial data");
        controller.updateView();

        //now updating address
        controller.setAddress("42069 Street");
        System.out.println("Updating Street:");
        controller.updateView();

        //now updating phoneNumber
        controller.setPhoneNumber("+41 79 069 69 69");
        System.out.println("Updating Phonenumber:");
        controller.updateView();

    }

    //generating generic employee
    private static EmployeeModel generateEmployeeFromTheVoid() {
        EmployeeModel employee = new EmployeeModel();
        employee.setName("Michael");
        employee.setSurname("Vuong");
        employee.setPhoneNumber("+41 78 420 69 69");
        employee.setAddress("FourTwentySixtyNine Street");
        employee.setID("Four2069");
        return employee;
    }
}
