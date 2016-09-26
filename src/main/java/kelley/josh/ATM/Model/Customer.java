package kelley.josh.ATM.Model;

import java.io.Serializable;

/**
 * Created by joshuakelley on 9/17/16.
 */
public class Customer implements Serializable{
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private int customerID;

    protected Customer(String firstName, String lastName, String userName, String password,int customerID){
        this.firstName=firstName;this.lastName=lastName;this.userName=userName;this.password=password;this.customerID=customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getCustomerID(){ return customerID;}

    public String toString(){
        return "Name: "+firstName + " "+lastName+" User Name: "+userName+" Customer ID#: "+customerID;
    }
}
