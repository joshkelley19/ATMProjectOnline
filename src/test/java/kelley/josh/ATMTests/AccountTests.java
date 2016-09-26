package kelley.josh.ATMTests;

import static org.junit.Assert.*;

import kelley.josh.ATM.Model.Engine;
import org.junit.Before;
import org.junit.Test;

/**
 * Created by joshuakelley on 9/17/16.
 */
public class AccountTests {
    Engine engine;

    @Before
    public void initialize(){
        engine =new Engine();
        engine.cm.createNewCustomer("Josh","Kelley","joshkelley19","kelley.josh");
        engine.createNewAccount(1,1000,1);
        engine.createNewAccount(1,1000,1);
        engine.manageAccounts(2,1,0,0);
    }
    @Test
    public void addAccountsTest0(){
        assertEquals(1, engine.am.selectAllCustomerAccounts(1).size());
    }
    @Test
    public void addAccountsTest1(){
        engine.createNewAccount(1,1000,1);
        assertEquals(2, engine.am.selectAllCustomerAccounts(1).size());
    }
    @Test
    public void withdrawTest(){
        engine.manageAccounts(3,1,200,0);
        double expected=800;
        double actual= engine.am.getCurrentAccount().getAccountBalance();
        assertEquals(expected,actual,1);
    }
    @Test
    public void testWithdrawFailSafe(){
        engine.manageAccounts(2,1,1200,0);
        double expected=1000;
        double actual= engine.am.getCurrentAccount().getAccountBalance();
        assertEquals(expected,actual,1);
    }
    @Test
    public void depositTest(){
        engine.manageAccounts(2,2,200,1);
        double expected=1200;
        double actual= engine.am.getCurrentAccount().getAccountBalance();
    }
    @Test
    public void transferToTest(){
        engine.createNewAccount(1,1000,1);
        engine.accessAccounts(3,500,2);
        double expected=500;
        double actual= engine.am.getCurrentAccount().getAccountBalance();
        assertEquals(expected,actual,1);
    }
    @Test
    public void transferFromTest(){
        engine.createNewAccount(1,1000,1);
        engine.accessAccounts(3,500,2);
        engine.manageAccounts(2,2,0,2);
        double expected=1500;
        double actual= engine.am.getCurrentAccount().getAccountBalance();
        assertEquals(expected,actual,1);
    }
    @Test
    public void closeAccountTest(){
        engine.accessAccounts(1,engine.am.getCurrentAccount().getAccountBalance(),0);
        engine.createNewAccount(4,0,0);
        assertNull(engine.am.getCurrentAccount());
    }

}
