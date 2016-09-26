package kelley.josh.ATM.Model;

import java.util.ArrayList;

/**
 * Created by joshuakelley on 9/16/16.
 */
public class AccountManager {
    protected static ArrayList<Account> accounts = new ArrayList<Account>();
    private static Account currentAccount;
    private static int accountIDCounter=900000;

    protected void selectAccount(int selection,int customerAccountID){
        currentAccount=selectAllCustomerAccounts(customerAccountID).get(selection-1);
    }

    public void createNewCheckingAccount(double money, int customerID){
        accountIDCounter++;
        accounts.add(new Account(Account.AccountType.CHECKINGS,money,accountIDCounter,customerID));
    }

    public void createNewSavingsAccount(double money,int customerID){
        accountIDCounter++;
        accounts.add(new Account(Account.AccountType.SAVINGS,money,accountIDCounter,customerID));
    }

    public void createNewInvestmentAccount(double money, int customerID){
        accountIDCounter++;
        accounts.add(new Account(Account.AccountType.INVESTMENT,money,accountIDCounter, customerID));
    }

    private Account findAccount(int accountIDToFind){
        for(Account match: accounts){
            if(match.getAccountID()==accountIDToFind){
                return match;
            }
        }
        return null;
    }

    public boolean closeAccount(){
        if(currentAccount.getAccountStatus()== Account.AccountStatus.OPEN){
            if(currentAccount.getAccountBalance()<1) {
                currentAccount.setAccountStatus(Account.AccountStatus.CLOSED);
                accounts.remove(currentAccount);
                currentAccount = null;
            }else System.out.println("Must Withdraw All Funds First");
        }else {
            System.out.println(noAccess());
            return false;
        }
        return false;
    }

    public boolean withdraw(double money){
        if(currentAccount.getAccountStatus()== Account.AccountStatus.OPEN){
            if(money<=currentAccount.getAccountBalance()) {
                currentAccount.setAccountBalance(currentAccount.getAccountBalance() - money);
                return true;
            }else System.out.println(notEnoughMoney());return false;
        }else{
            System.out.println(noAccess());
            return false;
        }

    }

    public boolean deposit(double money){
        if(currentAccount.getAccountStatus()== Account.AccountStatus.OPEN){
            currentAccount.setAccountBalance(currentAccount.getAccountBalance()+money);
            return true;
        }
        System.out.println(noAccess());
        return false;
    }

    public boolean transfer(double money, int receivingAccountID){
        if(currentAccount.getAccountStatus()== Account.AccountStatus.OPEN) {
            if ((currentAccount.getAccountBalance() > money) && acceptTransfer(receivingAccountID)) {
                withdraw(money);
                double receivedAmount = findAccount(receivingAccountID).getAccountBalance() + money;
                findAccount(receivingAccountID).setAccountBalance(receivedAmount);
                return true;
            }else return false;
        }else {
            System.out.println(noAccess());
            return false;
        }
    }

    private String notEnoughMoney(){
        return "Insufficient Funds";
    }

    private String noAccess(){
        return "Request Denied. Error: No access to account. Speak to a First Bank of Josh representative.";
    }

    public int printAccounts(int customerID){
        int counter=1;
        ArrayList<Account> customerAccounts=new ArrayList<Account>(selectAllCustomerAccounts(customerID));
        for (Account account: customerAccounts){
            System.out.println(counter+". "+account.toString());
            counter++;
        }
        return counter-1;//size
    }

    private boolean acceptTransfer(int receivingAccountID){
        if(findAccount(receivingAccountID)!=null){
            return true;
        }else return false;
    }

    public ArrayList<Account> selectAllCustomerAccounts(int customerID){
        ArrayList<Account> selectedAccounts = new ArrayList<Account>();
        for (Account account: accounts){
            if(account.getCustomerID()==customerID){
                selectedAccounts.add(account);
            }

        }
        return selectedAccounts;
    }

    public Account getCurrentAccount(){
        return currentAccount;
    }

    public static void setAccountIDCounter(int accountIDCounter) {
        AccountManager.accountIDCounter = accountIDCounter;
    }

    public static int getAccountIDCounter() {
        return accountIDCounter;
    }
}
