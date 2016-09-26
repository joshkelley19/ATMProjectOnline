package kelley.josh.ATM.Model;

import java.util.ArrayList;

public class CustomerManager {
    private static Customer currentCustomer;
    protected static ArrayList<Customer> customers = new ArrayList<Customer>();
    private static int customerIDCounter=100000;

    //manage account, change password, signout, printaccounts/selectaccounts, signin, requesttransactions,

    public boolean signIn(String user, String pass){
        currentCustomer=checkForExistingAccount(user, pass);
        if(currentCustomer!=null){
            return true;
        }else return false;
    }

    public boolean createNewCustomer(String firstName, String lastName, String userName, String password){
        customerIDCounter++;
        Customer createdCustomer=new Customer(firstName,lastName,userName,password,customerIDCounter);
        customers.add(createdCustomer);
        currentCustomer=createdCustomer;
        return true;
    }

    private Customer checkForExistingAccount(String user, String pass){
        for(Customer customer: customers){
            if(customer.getUserName().equals(user)&&customer.getPassword().equals(pass)){
                return customer;
            }
        }
        return null;
    }

    public Customer getCurrentCustomer(){
        return currentCustomer;
    }

    public ArrayList saveCustomers(){
        return customers;
    }

    public static void setCustomerIDCounter(int loadedcustomerIDCounter) {
        customerIDCounter = loadedcustomerIDCounter;
    }

    public static int getCustomerIDCounter() {
        return customerIDCounter;
    }
}
