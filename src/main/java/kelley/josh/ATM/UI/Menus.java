package kelley.josh.ATM.UI;

/**
 * Created by joshuakelley on 9/17/16.
 */
public class Menus {
    public void welcome(){
        System.out.println("Welcome to First Bank of Josh!\n\n");
    }
    public void exitSystem(){
        System.out.println("Goodbye!");
    }
    public void provideOptions(){
        System.out.println("What would you lke to do?");
    }
    public void customerMenu(){
        provideOptions();
        System.out.println("1. Sign Up\n2. Sign In\n3. Quit System");
    }
    public void manageAccountsMenu(){
        provideOptions();
        System.out.println("1. Create New Account\n2. Choose An Account\n3. Transactions\n4. View All Accounts\n5. Quit");
    }
    public void createNewAccountMenu(){
        System.out.println("What Type of Account Would you Like?");
        System.out.println("1. Checking\n2. Savings\n3. Investment\n4. Close Current Account\n5. Cancel");
    }
    public void accessAccountMenu(){
        provideOptions();
        System.out.println("1. Withdraw\n2. Deposit\n3. Transfer\n4. View Transactions for this Account\n5. Cancel");
    }
    public void requestAmount(){
        System.out.println("How Much for your Transaction?");
    }
    public void requestAmountForInitialDeposit(){
        System.out.println("How much are you starting your account with?");
    }
    public void promptForTransferAccount(){
        System.out.println("What account would you like to transfer to?");
    }
    public void selectAccountPrompt(){
        System.out.println("Select an Account");
    }
    public void enterUser(){
        System.out.print("Enter User Name: ");
    }
    public void enterPassword(){
        System.out.print("Enter Password: ");
    }
    public void enterFirstName(){
        System.out.print("Enter First Name: ");
    }
    public void enterLastName(){
        System.out.print("Enter Last Name: ");
    }
    public void noAccountFound(){
        System.out.println("No account matching that User Name and Password. Try Again\n\n");
    }

}
