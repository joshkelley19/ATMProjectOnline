package kelley.josh.ATM.Model;

import java.util.ArrayList;

public class TransactionManager {
protected static ArrayList<Transaction> transactions= new ArrayList<Transaction>();

    protected void createNewWithdrawalTransaction(double money, boolean success){
        transactions.add(new Transaction(Transaction.TransactionType.WITHDRAWAL,money,success));
    }

    protected void createNewDepositTransaction(double money, boolean success){
        transactions.add(new Transaction(Transaction.TransactionType.DEPOSIT,money,success));
    }

    protected void createNewTransferTransaction(double money, boolean success){
        transactions.add(new Transaction(Transaction.TransactionType.TRANSFER,money,success));
    }

    public void printTransactions(int accountID){
        for(Transaction transaction: transactions){
            if (transaction.getAccountID()==accountID) {
                System.out.println(transaction.toString());
            }
        }
    }
}
