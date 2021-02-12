package com.swcgroup15.assignment4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.time.Instant;

import static org.junit.Assert.*;

public class TechnicianTest {
    static WebTechnician Michael;
    static BackendTechnician Nicolas;
    static DataBase db;

    @Before
    public void createRegularEmployeeAndCustomer(){
        //this part should be re-instantiated every time
        db =DataBase.DataBase();
        Michael = new WebTechnician("Kek","W",db);
        Nicolas = new BackendTechnician("LUL","W",db);
    }
    @Test
    /**
     * After initializing, a Technician should have following personality-attributes: Name, Surname and an ID.
     * Since both Web- and Backendtechnician are not overriding the abstract Class Technician,
     * it's ok to just test WebTechnician
     * @param exepctecOutput Name which is compared to the method call Michael.getTechnicianName()
     * @param expectedOutput2 Surname which is compared to the method call Michael.getTechnicianSurname()
     * Further we tested whether the Technician is existing and if his ID is a positive number
     */
    public void shouldCreateTechnicianPersonality(){
        String expectedOutput = "Kek";
        String expectedOutput2 = "W";

        assertNotNull(Michael); //checking if object is existing
        assertEquals(expectedOutput, Michael.getTechnicianName());
        assertEquals(expectedOutput2, Michael.getTechnicianSurname());
        assertTrue(Michael.getTechnicianID()>0);
    }
    @Test
    /**
     * using an artificial stopwatch with the start button beeing
     * @param start and the stop button
     * @param finish
     * we measure the time passed.
     * @param timeElapsed is finish - start which should be 30 seconds.
     */
    public void shouldWait30Seconds(){
        Instant start = Instant.now();
        Michael.fixWebsite();
        Instant finish = Instant.now();
        long timeElapsed = Duration.between(start, finish).toSeconds();

        assertEquals(30, timeElapsed);
    }
    @Test
    /**
     * Making sure that he actually fixed it by comparing the string output.
     * @param outContent = actual output
     * @param expectedOutput = expected output
     */
    public void shouldFixBackend(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Nicolas.fixBackend(Nicolas.ID);
        String expectedOutput = "Fixed!\r\n";
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