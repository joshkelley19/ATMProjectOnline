package kelley.josh.ATM.App;

import kelley.josh.ATM.Model.Administrator;
import kelley.josh.ATM.Model.Engine;
import kelley.josh.ATM.UI.Menus;
import kelley.josh.ATM.UI.UserInput;

public class ATM {
    UserInput userInput = new UserInput();
    Menus menus = new Menus();
    Engine engine = new Engine();
    int customerMenuChoice;
    int subOption;
    int receivingAccountID;
    String firstName;
    String lastName;
    String userName;
    String password;
    double money;

    public void start() {
        menus.welcome();
        //engine.loadProgram();
        while (topMenu()){
            while (accountMenu());
        }
        engine.saveProgram();
        menus.exitSystem();
    }

    public boolean topMenu() {
        menus.customerMenu();
        customerMenuChoice = userInput.getInt();
        switch (customerMenuChoice) {
            case 1:
                menus.enterFirstName();
                firstName=userInput.getString();
                menus.enterLastName();
                lastName=userInput.getString();
                menus.enterUser();
                userName=userInput.getString();
                menus.enterPassword();
                password=userInput.getString();
                break;
            case 2:
                menus.enterUser();
                userName=userInput.getString();
                menus.enterPassword();
                password=userInput.getString();break;
            case 3:
                return false;
            case 4:
                Administrator.printCustomers();
                userInput.getString();
        }
        engine.manageCustomer(customerMenuChoice, firstName, lastName, userName, password);
        return true;
    }

    public boolean accountMenu(){
        if(engine.cm.getCurrentCustomer()==null){
            menus.noAccountFound();return false;
        }
        boolean quit;
        menus.manageAccountsMenu();
        customerMenuChoice=userInput.getInt();
        switch (customerMenuChoice){
            case 1:menus.createNewAccountMenu();
                subOption=userInput.getInt();
                menus.requestAmountForInitialDeposit();
                money=userInput.getDouble();break;
            case 2:engine.am.printAccounts(engine.cm.getCurrentCustomer().getCustomerID());
                menus.selectAccountPrompt();
                subOption=userInput.getInt();break;
            case 3:menus.accessAccountMenu();
                subOption=userInput.getInt();
                switch (subOption) {
                    case 1:
                    case 2:menus.requestAmount();
                        money = userInput.getDouble();break;
                    case 3:menus.requestAmount();
                        money = userInput.getDouble();
                        menus.promptForTransferAccount();
                        receivingAccountID = userInput.getInt();break;
                    case 4:engine.tm.printTransactions(engine.am.getCurrentAccount().getAccountID());break;
                    case 5:return true;
                    default:
                }
            case 4:break;
            case 5:return false;
        }
        quit=engine.manageAccounts(customerMenuChoice,subOption,money,receivingAccountID);
        return quit;
    }

    public static void main(String[] args) {
        ATM atm = new ATM();
        atm.start();
    }
}
