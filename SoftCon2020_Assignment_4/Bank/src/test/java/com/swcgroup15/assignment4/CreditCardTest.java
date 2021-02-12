package com.swcgroup15.assignment4;

// need to import this

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class CreditCardTest {
    static RegularEmployee Klaus;
    static Customer Fred;
    static DataBase db;

    @Before
    public void createRegularEmployeeAndCustomer() {
        //this part should be re-instantiated every time
        db = DataBase.DataBase();
        Klaus = new RegularEmployee("Klaus", "Muster", db);
        Fred = Klaus.createCustomer("Fred", "Dy", db);
    }

    @Test
    /**
     * After initializing a Customer (by an Employee), its serialNr should have a length of 16
     * @param actualOutput = actual output, by calling Fred.getCreditCard().getCreditcard.Serial()
     * @param expectedOutput = expected output, length of 16
     */
    public void shouldReturnCorrectLengthOfSerialNr(){
        Integer expectedOutput = 16;
        Integer actualOutput = (Fred.getCreditCard().getCreditcardSerial()).length();
        assertTrue(expectedOutput == actualOutput);
    }
    //everything else is already tested in other tests
}