package kelley.josh.ATM.Model;

import java.io.Serializable;
import java.util.Date;

public class Transaction implements Serializable{
    public enum TransactionType{
    WITHDRAWAL, DEPOSIT, TRANSFER;
}
    private TransactionType transactionType;
    private Date transactionDate;
    private double transactionAmount;
    private boolean isSuccessful;
    private int accountID;

    public Transaction(TransactionType type,double amount, boolean success){
        this.transactionType=type;this.transactionAmount=amount;this.isSuccessful=success;transactionDate=new Date();
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Date getTransactionDate() {
        return transactionDate;
    }

    public boolean getSuccess(){
        return isSuccessful;
    }

    public int getAccountID(){return accountID;}

    @Override
    public String toString() {
        String successful=(isSuccessful)?"Approved":"Denied";
        return "Transaction Type: "+transactionType+" Was "+successful+" For Account # "+accountID+", Amount: "+transactionAmount+
                " "+successful+", Time: "+transactionDate;
    }



}
