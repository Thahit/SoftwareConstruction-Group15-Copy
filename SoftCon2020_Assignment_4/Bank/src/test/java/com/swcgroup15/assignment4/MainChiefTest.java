package com.swcgroup15.assignment4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class MainChiefTest {

    static MainChief Klaus;
    static Customer Fred;
    static DataBase db;
    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void createMainChiefEmployeeAndCustomer(){
        //this part should be re-instantiated every time
        db=DataBase.DataBase();
        Klaus = new MainChief("Klaus", "Muster",db);
        Fred = Klaus.createCustomer("Fred", "Dy",db);
    }

    @Test
    /**
     * We are comparing the actual with the expected output using
     * @param expectedOutput, which is the expected Output we set and
     * the method call Fred.getCustomerState() which should return the golden state after an upgrade.
     * @return nothing. The method is void.
     */
    public void shouldUpgradeToGoldState() {
        Klaus.upgrade(Fred.getCustomerID(),db);
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
    public void shouldUpgradeToPlatinumState(){

        Klaus.upgrade(Fred.getCustomerID(),db);
        Klaus.upgrade(Fred.getCustomerID(),db);
        State expectedOutput = Fred.getCreditCard().getPlatinumState();

        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * Since there is no state higher than platinum we should get an exception which we expect here as a throw.
     */
    public void shouldNotUpgradeHigherThanPlatinum(){
        Klaus.upgrade(Fred.getCustomerID(),db);
        Klaus.upgrade(Fred.getCustomerID(),db);
        exception.expect(IllegalCallerException.class);
        Klaus.upgrade(Fred.getCustomerID(),db);

    }

    @Test
    /**
     * Comparing the expected output with the actual (Fred.getCustomerState()).
     * @param expectedOutput the expected output.
     */
    public void shouldDowngradeFromPlatToGold() {
        Klaus.upgrade(Fred.getCustomerID(),db); // we know that this actually upgrade to Gold since we tested it before this Test
        Klaus.upgrade(Fred.getCustomerID(),db);

        Klaus.downgrade(Fred.getCustomerID(),db);

        State expectedOutput = Fred.getCreditCard().getGoldenState();

        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * Comparing the expected output with the actual (Fred.getCustomerState()).
     * @param expectedOutput the expected output (called by Fred.getCreditCard().getRegularState()
     */
    public void shouldDowngradeFromGoldToReg(){
        Klaus.upgrade(Fred.getCustomerID(),db); // we know that this actually upgrade to Gold since we tested it before this Test
        Klaus.downgrade(Fred.getCustomerID(),db);

        State expectedOutput = Fred.getCreditCard().getRegularState();

        assertEquals(expectedOutput, Fred.getCustomerState());
    }

    @Test
    /**
     * There is no state below regular. Expecting a throw "Exception"
     */
    public void shouldNotDowngradeLowerThanReg(){
        Klaus.upgrade(Fred.getCustomerID(),db);
        Klaus.upgrade(Fred.getCustomerID(),db);
        Klaus.downgrade(Fred.getCustomerID(),db);
        Klaus.downgrade(Fred.getCustomerID(),db);
        exception.expect(IllegalCallerException.class);
        Klaus.downgrade(Fred.getCustomerID(),db);
    }
    @After
    /**
     * cleaning up all id for the next test round by resetting the database.
     */
    public void ResetDataBase(){
        db.clearDb();
    }
}