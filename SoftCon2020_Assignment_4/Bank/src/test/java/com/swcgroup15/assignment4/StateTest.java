package com.swcgroup15.assignment4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class StateTest{
    static DataBase db;
    static RegularEmployee Klaus;
    static Customer Fred;

    @Before
    public void createCreditCard(){
        db =DataBase.DataBase();
        Klaus = new MainChief("Klaus", "Muster",db);
        Fred = Klaus.createCustomer("Fred", "Dy",db);
    }
    @Test
    /**
     * @param Fred is the customer
     * @param Klaus is the Mainchief.
     * To simulate a whole process through every state we use a mainchief and a customer.
     * In this case, every use of the creditcard is in range of the allowed limit.
     * After each use of the creditcard we upgrade the customer and are using the creditcard again.
     * After reaching platinum we downgrade until we reach regular state.
     */
    public void usingCreditCard(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.useCreditCard(1000);
        String expectedOutput  = "Bill successfully paid\r\n";
        Klaus.upgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(2001);
        String expectedOutput2 = "Bill successfully paid\r\n";
        Klaus.upgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(5001);
        String expectedOutput3 = "Bill successfully paid\r\n";
        Klaus.downgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(2001);
        String expectedOutput4 = "Bill successfully paid\r\n";
        Klaus.downgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(1000);
        String expectedOutput5 = "Bill successfully paid\r\n";

        assertEquals(expectedOutput+""+expectedOutput2+""+expectedOutput3+""+expectedOutput4+""+expectedOutput5, outContent.toString());
    }
    @Test
    /**
     * @param Fred is the customer
     * @param Klaus is the Mainchief.
     * To simulate a whole process through every state we use a mainchief and a customer.
     * In this case, every use of the creditcard is not in range of the allowed limit.
     * After each use of the creditcard we upgrade the customer and are using the creditcard again.
     * After reaching platinum we downgrade until we reach regular state.
     */
    public void shouldDenyCreditCard(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Fred.useCreditCard(2001);
        String expectedOutput  = "Creditcard: *declined*\r\n";
        Klaus.upgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(5001);
        String expectedOutput2 = "Creditcard: *declined*\r\n";
        Klaus.upgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(10001);
        String expectedOutput3 = "Creditcard: *declined*\r\n";
        Klaus.downgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(5001);
        String expectedOutput4= "Creditcard: *declined*\r\n";
        Klaus.downgrade(Fred.getCustomerID(),db);
        Fred.useCreditCard(2001);
        String expectedOutput5 = "Creditcard: *declined*\r\n";

        assertEquals(expectedOutput+""+expectedOutput2+""+expectedOutput3+""+expectedOutput4+""+expectedOutput5, outContent.toString());
    }
    @After
    /**
     * cleaning up all id for the next test round by resetting the database.
     */
    public void ResetDataBase(){
        db.clearDb();
    }
}