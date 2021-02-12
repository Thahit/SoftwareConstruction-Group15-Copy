package com.swcgroup15.assignment4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;


public class CustomerTest {
    static RegularEmployee Klaus;
    static Customer Fred;
    static DataBase db;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void createRegularEmployeeAndCustomer(){
        //this part should be re-instantiated every time
        db =DataBase.DataBase();
        Klaus = new RegularEmployee("Klaus", "Muster",db);
        Fred = Klaus.createCustomer("Fred", "Dy",db);

    }

    @Test
    /**
     * After initializing a customer he should have following personality-attributes: Name, Surname, Age between 18 and 100,
     * an ID and a Bank Nr.
     */
    public void shouldCreateCustomerPersonality(){
        String expectedOutput = "Fred";
        String expectedOutput2 = "Dy";

        assertNotNull(Fred); //checking if object is existing
        assertEquals(expectedOutput, Fred.getCustomerName());
        assertEquals(expectedOutput2, Fred.getCustomerSurname());
        assertTrue(((Fred.getCustomerAge()>=18) && (Fred.getCustomerAge()<=100)));
        assertTrue(Fred.getCustomerID()>0);
        assertTrue(Fred.getCustomerBankNr()>0);
    }



    @Test
    /**
     * After initializing a customer his state should be regular.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     */
    public void shouldReturnRegularState() {
        State expectedOutput = Fred.getCreditCard().getRegularState();
        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * Making sure he is deposing money by comparing the string output.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldDeposit(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.deposit(20);
        String expectedOutput  = "*Deposits Money*\r\n";

        assertEquals(expectedOutput, outContent.toString());

    }

    @Test
    /**
     * Making sure he is withdrawing money by comparing the string output.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldWithdrawRightAmount(){
        Fred.deposit(20);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.withdraw(10);
        String expectedOutput  = "*Withdraws Money*\r\n";
        assertEquals(expectedOutput, outContent.toString());

    }
    @Test
    /**
     * Making sure he cannot withdraw money by comparing the string output.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldDenyWithdrawing(){
        Fred.deposit(20);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.withdraw(30);
        String expectedOutput  = "*Failed to withdraw Money*\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }
    @Test
    /**
     * Making sure he is using the bankTransfer method by comparing the string output.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldUseBankTransfer(){
        Fred.deposit(20);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.bankTransfer(10);
        String expectedOutput  = "*Pays With Savings*\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    /**
     * Making sure he cannot use the bankTransfer method by comparing the string output.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldDenyBankTransfer(){

        Fred.deposit(20);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.bankTransfer(30);
        String expectedOutput  = "*Fails to pay With Savings*\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    /**
     * Making sure he cannot use the bankTransfer method by using negative inputs.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldDenyBankTransfer2(){

        Fred.deposit(20);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.bankTransfer(-30);
        String expectedOutput  = "*Fails to pay With Savings*\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    /**
     * Making sure he cannot deposit negative amounts of money.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     * @param Fred is the customer
     */
    public void shouldDenyDepost(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.deposit(-20);
        String expectedOutput  = "*Illegal Input*\r\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @After
    /**
     * cleaning up all id for the next test round by resetting the database.
     */
    public void ResetDataBase(){
        db.clearDb();
    }
}