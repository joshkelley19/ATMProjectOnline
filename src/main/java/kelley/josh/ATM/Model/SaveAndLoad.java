package kelley.josh.ATM.Model;

import java.io.*;
import java.util.ArrayList;

public class SaveAndLoad {

    public void saveApp(ArrayList collection, String file){

        try(FileOutputStream fileOutputStream= new FileOutputStream(file);
            ObjectOutputStream objectOutputStream= new ObjectOutputStream(fileOutputStream)){
            objectOutputStream.writeObject(collection);
        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void loadCustomers(){
        try(FileInputStream fileInputStream = new FileInputStream("Customers.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            ArrayList<Customer> temp=(ArrayList<Customer>) objectInputStream.readObject();
            CustomerManager.customers = temp;
            Administrator.setCustomers(temp);
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }

    public void loadAccounts(){
        try(FileInputStream fileInputStream = new FileInputStream("Accounts.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            AccountManager.accounts = (ArrayList<Account>) objectInputStream.readObject();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }

    }

    public void loadTransactions(){
        try(FileInputStream fileInputStream = new FileInputStream("Transactions.txt");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream))
        {
            TransactionManager.transactions = (ArrayList<Transaction>) objectInputStream.readObject();
        }catch(IOException ioe){
            ioe.printStackTrace();
            return;
        }catch(ClassNotFoundException c){
            System.out.println("Class not found");
            c.printStackTrace();
            return;
        }
    }
    public void loadIDs(){
        try(ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("IDNumbers.txt"))){
            CustomerManager.setCustomerIDCounter(objectInputStream.readInt());
            AccountManager.setAccountIDCounter(objectInputStream.readInt());
        }catch(IOException e){
            System.out.println("ID Load Unsuccessful");
            e.printStackTrace();
        }
    }

    public void saveIDs(){
        try(ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("IDNumbers.txt"))){
            objectOutputStream.write(CustomerManager.getCustomerIDCounter());
            objectOutputStream.write(AccountManager.getAccountIDCounter());
        }catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }catch (IOException i){
            System.out.println("Something went wrong");
            i.printStackTrace();
        }
    }

}
