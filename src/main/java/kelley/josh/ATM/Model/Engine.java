package kelley.josh.ATM.Model;

public class Engine {
    public CustomerManager cm=new CustomerManager();
    public AccountManager am=new AccountManager();
    public TransactionManager tm=new TransactionManager();
    private SaveAndLoad saveAndLoad = new SaveAndLoad();

    public boolean manageCustomer(int selection,String firstName, String lastName, String userName, String password){
        boolean quit=true;
        switch (selection){
            case 1:cm.createNewCustomer(firstName,lastName,userName,password);break;
            case 2:cm.signIn(userName,password);break;
            case 3:break;
            default:
                System.out.println("Unavailable entry");
        }
        return quit;
    }

    public boolean manageAccounts(int selection,int subOption,double money,int receivingAccountID){
        boolean quit=true;
        switch (selection){
            case 1:createNewAccount(subOption,money,cm.getCurrentCustomer().getCustomerID());break;
            case 2:am.selectAccount(subOption,cm.getCurrentCustomer().getCustomerID());break;
            case 3:if(am.getCurrentAccount()!=null){
                accessAccounts(subOption,money,receivingAccountID);break;
            }else {
                System.out.println("No Account Selected");
            }break;
            case 4:am.printAccounts(cm.getCurrentCustomer().getCustomerID());break;
            case 5:quit=false;break;
            default:
                System.out.println("Unavailable entry");
        }
        return quit;
    }

    public boolean createNewAccount(int selection, double money, int customerID){
        boolean quit=true;
        switch (selection){
            case 1:am.createNewCheckingAccount(money, customerID);break;
            case 2:am.createNewSavingsAccount(money, customerID);break;
            case 3:am.createNewInvestmentAccount(money, customerID);break;
            case 4:if(am.getCurrentAccount()!=null) {
                am.closeAccount();
            }else {
                System.out.println("No Account Selected");
            }break;
            case 5:quit=false;break;
            default:
                System.out.println("Unavailable entry");
        }
        return quit;
    }

    public boolean accessAccounts(int selection, double money,int receivingAccountId){
        boolean quit=true;
        switch (selection){
            case 1:tm.createNewWithdrawalTransaction(money,am.withdraw(money));break;
            case 2:tm.createNewDepositTransaction(money,am.deposit(money));break;
            case 3:tm.createNewTransferTransaction(money,am.transfer(money,receivingAccountId));break;
            case 4:tm.printTransactions(am.getCurrentAccount().getAccountID());break;
            case 5:quit=false;break;
            default:
                System.out.println("Unavailable entry");
        }
        return quit;
    }

    public void loadProgram(){
        saveAndLoad.loadCustomers();
        saveAndLoad.loadAccounts();
        saveAndLoad.loadTransactions();
        saveAndLoad.loadIDs();
    }

    public void saveProgram(){
        saveAndLoad.saveApp(CustomerManager.customers,"Customers.txt");
        saveAndLoad.saveApp(AccountManager.accounts,"Accounts.txt");
        saveAndLoad.saveApp(TransactionManager.transactions,"Transactions.txt");
        saveAndLoad.saveIDs();
    }
}
