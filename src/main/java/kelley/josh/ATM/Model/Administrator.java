package kelley.josh.ATM.Model;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 9/23/16.
 */
public class Administrator {
    private static ArrayList<Customer> customers=new ArrayList<Customer>();
    private static String userName="josh";
    private static String password="kelley";

    public static void setCustomers(ArrayList<Customer> customers) {
        Administrator.customers = customers;
    }
    public static void printCustomers(){
        System.out.println(customers);
    }
}
