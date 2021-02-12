package com.swcgroup15.assignment4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class SectionChiefTest {

    static SectionChief Klaus;
    static Customer Fred;
    static DataBase db;
    static SectionChief SecondSectionChief;
    static RegularEmployee ProblemMaker;
    static Customer InvalidTester;


    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void createSectionChiefEmployeeAndCustomer() {
        db = DataBase.DataBase();
        Klaus = new SectionChief("Klaus", "Muster", "Gotham", db);
        Fred = Klaus.createCustomer("Fred", "Dy", db);
        ProblemMaker = new RegularEmployee("Problem", "Maker", db);
        InvalidTester = ProblemMaker.createCustomer("Invalid", "Tester",db);

    }
    @Test
    /**
     * After initializing, a SectionChief will have one more attribute: City
     * @param expectedOutput, which is the expected City-Output we set and
     * the method call Klaus.getEmployeeCity() which should return the City "Gotham" (as defined by Klaus)
     * Note: All other attributes have been tested in RegularEmployeeTest
     */
    public void shouldCreateExtraPersonality(){
        String expectedOutput = "Gotham";
        assertEquals(expectedOutput, Klaus.getEmployeeCity());
    }

    @Test
    /**
     * We are comparing the actual with the expected output using
     * @param expectedOutput, which is the expected Output we set and
     * the method call Fred.getCustomerState() which should return the golden state after an upgrade.
     * @return nothing. The method is void.
     */
    public void shouldUpgradeToGoldState() {
        Klaus.upgrade(Fred.getCustomerID(), db);
        State expectedOutput = Fred.getCreditCard().getGoldenState();

        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * We are comparing the actual with the expected output using
     * @param expectedOutput, which is the expected Output we set and
     * the method call Fred.getCustomerState() which should return the golden state after 2 upgrades.
     * @return nothing. The method is void.
     */
    public void shouldUpgradeToPlatinumState() {
        Klaus.upgrade(Fred.getCustomerID(), db);
        Klaus.upgrade(Fred.getCustomerID(), db);
        State expectedOutput = Fred.getCreditCard().getPlatinumState();

        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * Since there is no state higher than platinum we should get an exception which we expect here.
     */
    public void shouldNotUpgradeHigherThanPlatinum() {
        Klaus.upgrade(Fred.getCustomerID(), db);
        Klaus.upgrade(Fred.getCustomerID(), db);
        exception.expect(IllegalCallerException.class);
        Klaus.upgrade(Fred.getCustomerID(), db);

    }

    @Test
    /**
     * Comparing the expected output with the actual (Fred.getCustomerState()).
     * @param expectedOutput the expected output.
     */
    public void shouldDowngradeFromGoldToReg() {
        Klaus.upgrade(Fred.getCustomerID(), db);
        Klaus.downgrade(Fred.getCustomerID(), db);
        State expectedOutput = Fred.getCreditCard().getRegularState();
        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * First we upgrade Fred 2 times to get him into the platinumstate and afterwards we downgrade him.
     * Since Klaus is  a sectionchief he should not be able to do that.
     * @param outContent is the actual output
     * @param expectedOutput should be "Permission denied".
     */
    public void shouldDenyPermToDowngradeFromPlatToGold() {
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        //This will upgrade Customer to Platinum, we checked this earlier
        Klaus.upgrade(Fred.getCustomerID(), db);
        Klaus.upgrade(Fred.getCustomerID(), db);
        //This should not be possible since Klaus is only a SectionChief Employee
        Klaus.downgrade(Fred.getCustomerID(), db);
        String expectedOutput = "Permission denied";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    /**
     * There is no state below regular. Should throw an exception.
     */
    public void shouldNotDowngradeLowerThanReg() {
        Klaus.upgrade(Fred.getCustomerID(), db);
        Klaus.downgrade(Fred.getCustomerID(), db);
        exception.expect(IllegalCallerException.class);
        Klaus.downgrade(Fred.getCustomerID(), db);
    }

    @Test
    /**
     * There is only 1 section chief per city. If we create a second one, it should throw an exception.
     * @param SeconSectionChief is the second section chief we created.
     */
    public void shouldNotHaveMoreThan1SectionChiefPerCity() {
        exception.expect(java.lang.Error.class);
        exception.expectMessage("City already used");
        SecondSectionChief = new SectionChief("Second", "SectionChief", "Gotham", db);
    }

    @Test
    /**
     * If Klaus uses an id which is not in his list it should return an error which we test here by using a customer from another employee list.
     * @param InvalidTester is the customer from ProblemMakers list.
     * @return nothing. The method is void.
     */
    public void shouldNotHavePermissionToWorkOnOtherCustomerList(){
        exception.expect(IllegalArgumentException.class);
        exception.expectMessage("Invalid ID");
        Klaus.upgrade(InvalidTester.getCustomerID(),db);
    }

    @After
    /**
     * cleaning up all id for the next test round by resetting the database.
     */
    public void ResetDataBase(){
        db.clearDb();
    }
}