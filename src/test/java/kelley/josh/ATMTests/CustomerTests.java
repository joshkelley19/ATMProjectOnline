package kelley.josh.ATMTests;

import kelley.josh.ATM.Model.CustomerManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Created by joshuakelley on 9/17/16.
 */
public class CustomerTests {
    CustomerManager cm;

    @Before
    public void initialize(){
        cm=new CustomerManager();
    }
    @Test
    public void createCustomerTest(){
        assertTrue(cm.createNewCustomer("Josh","Kelley","joshkelley19","kelley.josh"));
    }
    @Test
    public void signInTest(){
        cm.createNewCustomer("Josh","Kelley","joshkelley19","kelley.josh");
        assertTrue(cm.signIn("joshkelley19","kelley.josh"));
    }
}
