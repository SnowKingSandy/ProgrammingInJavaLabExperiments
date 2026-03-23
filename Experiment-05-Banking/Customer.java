import java.util.*;

public class Customer {
    private String customerId;
    private String name;
    private String email;
    private String phone;
    private List<Account> accounts;

    public Customer(String customerId, String name, String email, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.accounts = new ArrayList<>();
    }

    public String getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        for (Account account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }
        return null;
    }

    public double getTotalBalance() {
        double total = 0;
        for (Account account : accounts) {
            total += account.getBalance();
        }
        return total;
    }

    public void displayCustomerDetails() {
        System.out.println("\n--- CUSTOMER PROFILE ---");
        System.out.println("Customer ID: " + customerId);
        System.out.println("Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
        System.out.println("Total Accounts: " + accounts.size());
        System.out.println("Total Balance: Rs. " + String.format("%.2f", getTotalBalance()));
    }

    public void displayAllAccounts() {
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
        } else {
            System.out.println("\n--- Accounts for Customer " + name + " ---");
            for (Account account : accounts) {
                account.displayAccountDetails();
            }
        }
    }

    public void displayConsolidatedInfo() {
        displayCustomerDetails();
        System.out.println("\n--- ACCOUNT SUMMARY ---");
        if (accounts.isEmpty()) {
            System.out.println("No accounts.");
        } else {
            for (Account account : accounts) {
                System.out.println("  " + account.getAccountType() + " | Acc#: " + 
                    account.getAccountNumber() + " | Balance: Rs. " + 
                    String.format("%.2f", account.getBalance()));
            }
        }
    }
}
