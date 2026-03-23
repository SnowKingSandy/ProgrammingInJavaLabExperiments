import java.util.*;
import java.time.LocalDateTime;

public abstract class Account {
    protected String accountNumber;
    protected String accountType;
    protected double balance;
    protected List<Transaction> transactions;
    protected LocalDateTime createdDate;

    public Account(String accountNumber, String accountType, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
        this.createdDate = LocalDateTime.now();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    // Abstract methods to be implemented by child classes
    public abstract void deposit(double amount);

    public abstract void withdraw(double amount);

    public void displayAccountDetails() {
        System.out.println("\n--- Account Details ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Type: " + accountType);
        System.out.println("Balance: Rs. " + String.format("%.2f", balance));
        System.out.println("Created Date: " + createdDate);
    }

    public void displayTransactionHistory() {
        System.out.println("\n--- Transaction History for " + accountNumber + " ---");
        if (transactions.isEmpty()) {
            System.out.println("No transactions yet.");
        } else {
            for (Transaction t : transactions) {
                System.out.println(t);
            }
        }
    }
}
