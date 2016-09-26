package kelley.josh.ATM.Model;

import java.io.Serializable;

public class Account implements Serializable{
    protected enum AccountType{
        CHECKINGS, SAVINGS, INVESTMENT;
    }
    protected enum AccountStatus{
        OPEN, CLOSED, FROZEN;
    }
    private AccountType accountType;
    private AccountStatus accountStatus=AccountStatus.OPEN;
    private double accountBalance;
    private int accountID;
    private final int customerID;


    protected Account(AccountType type,double balance, int accountID, int customerID){
        this.accountType=type;this.accountBalance=balance;this.accountID=accountID;this.customerID=customerID;
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public AccountStatus getAccountStatus() {
        return accountStatus;
    }

    public void setAccountStatus(AccountStatus accountStatus) {
        this.accountStatus = accountStatus;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    public int getAccountID() {
        return accountID;
    }

    public void setAccountID(int accountID) {
        this.accountID = accountID;
    }

    public int getCustomerID(){
        return customerID;
    }

    public String toString(){
        return "Account Type: "+accountType+", ID: "+accountID+", Balance: "+accountBalance+", Status: "+accountStatus;
    }
}
