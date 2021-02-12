package com.swcgroup15.assignment4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class RegularEmployeeTest {

    static RegularEmployee Klaus;
    static RegularEmployee ProblemMaker;
    static Customer Fred;
    static Customer InvalidTester;
    static DataBase db;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void createRegularEmployeeAndCustomer(){
        db= DataBase.DataBase();
        Klaus = new RegularEmployee("Klaus", "Muster", db);
        Fred = Klaus.createCustomer("Fred", "Dy",db);
        ProblemMaker = new RegularEmployee("Problem", "Maker", db);
        InvalidTester = ProblemMaker.createCustomer("Invalid", "Tester",db);

    }
    @Test
    /**
     * After initializing, an employee should have following personality-attributes: Name, Surname, an ID and CustomerList.
     * @param expectedOutput Name of Employee which is compared to the method call Klaus.getEmployeeName()
     * @param expectedOutput2 Surname of Employee which is compared to the method call Klaus.getEmployeeSurname()
     * Further we tested whether the object is existing, if the ID is a positive number and
     * if the Employee has his own Customer List.
     */
    public void shouldCreateEmployeePersonality(){
        String expectedOutput = "Klaus";
        String expectedOutput2 = "Muster";

        assertNotNull(Klaus); //checking if object is existing
        assertEquals(expectedOutput, Klaus.getEmployeeName());
        assertEquals(expectedOutput2, Klaus.getEmployeeSurname());
        assertTrue(Klaus.getEmployeeID()>0);
        assertNotNull(Klaus.getEmployeeCustomerList());
    }

    @Test
    /**
     * By using the upgrade methods 2 times, we make sure that a regular employee cannot upgrade from regular to platinum.
     * @param outContent We need this to compare output strings in void methods.
     * @param expectedOutput is the expected Output we set which we compare with the actual input.
     */
    public void shouldDenyPermissionToUpgrade(){

        Klaus.upgrade(Fred.getCustomerID(),db);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Klaus.upgrade(Fred.getCustomerID(),db);
        String expectedOutput  = "Permission denied";

        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    /**
     * We are comparing the actual with the expected output using
     * @param expectedOutput, which is the expected Output we set and
     * the method call Fred.getCustomerState() which should return the golden state after an upgrade.
     */
    public void shouldUpgradeToGoldState(){
        Klaus.upgrade(Fred.getCustomerID(),db);
        State expectedOutput = Fred.getCreditCard().getGoldenState();

        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * Since Klaus is a regular employee he should not be able to downgrade anyone.
     * @param outContent is the string which is printed out if Klaus tries to downgrade anyone.
     * @param expectedOutput is the message "Permission denied" which we expect.
     */
    public void shouldDenyPermissionToDowngrade(){
        Klaus.downgrade(Fred.getCustomerID(),db);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        Klaus.downgrade(Fred.getCustomerID(),db);
        String expectedOutput  = "Permission denied";

        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    /**
     * If Klaus uses an id which is not in his list it should return an error which we test here by using a customer from another employee list.
     * @param InvalidTester is the customer from ProblemMakers list.
     */
    public void shouldNotHavePermissionToWorkOnOtherCustomerList(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid ID");
        Klaus.upgrade(InvalidTester.getCustomerID(),db);
    }

    /**
     * cleaning up all id for the next test round by resetting the database.
     */
    @After
    public void ResetDataBase(){
        db.clearDb();
    }
}