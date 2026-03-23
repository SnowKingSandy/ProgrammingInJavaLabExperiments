import java.util.*;

public class BankingApplication {
    private static List<Customer> customers = new ArrayList<>();
    private static int accNumberCounter = 1000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("========================================");
        System.out.println("  WELCOME TO BANKING APPLICATION v1.0  ");
        System.out.println("========================================\n");

        while (running) {
            displayMenu();
            System.out.print("Enter your choice: ");
            int choice = getIntInput(scanner);

            switch (choice) {
                case 1:
                    createCustomer(scanner);
                    break;
                case 2:
                    viewCustomerDetails(scanner);
                    break;
                case 3:
                    manageAccounts(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using Banking Application!");
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\n--- MAIN MENU ---");
        System.out.println("1. Create New Customer");
        System.out.println("2. View Customer Details");
        System.out.println("3. Manage Accounts");
        System.out.println("4. Exit");
    }

    private static void createCustomer(Scanner scanner) {
        System.out.println("\n--- CREATE NEW CUSTOMER ---");
        System.out.print("Enter Name: ");
        String name = scanner.nextLine().trim();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine().trim();
        System.out.print("Enter Phone: ");
        String phone = scanner.nextLine().trim();

        String custId = "CUST" + generateId();
        Customer customer = new Customer(custId, name, email, phone);
        customers.add(customer);

        System.out.println("\nCustomer created successfully!");
        System.out.println("Customer ID: " + custId);
    }

    private static void viewCustomerDetails(Scanner scanner) {
        System.out.println("\n--- VIEW CUSTOMER DETAILS ---");
        Customer customer = selectCustomer(scanner);
        if (customer == null) {
            System.out.println("Invalid customer selection.");
            return;
        }

        customer.displayConsolidatedInfo();
    }

    private static void manageAccounts(Scanner scanner) {
        System.out.println("\n--- MANAGE ACCOUNTS ---");
        Customer customer = selectCustomer(scanner);
        if (customer == null) {
            System.out.println("Invalid customer selection.");
            return;
        }

        boolean managing = true;
        while (managing) {
            System.out.println("\n--- Account Management ---");
            System.out.println("1. Create Savings Account");
            System.out.println("2. View Accounts");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter choice: ");

            int choice = getIntInput(scanner);
            switch (choice) {
                case 1:
                    createSavingsAccount(scanner, customer);
                    break;
                case 2:
                    customer.displayAllAccounts();
                    break;
                case 3:
                    depositMoney(scanner, customer);
                    break;
                case 4:
                    withdrawMoney(scanner, customer);
                    break;
                case 5:
                    managing = false;
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    private static void createSavingsAccount(Scanner scanner, Customer customer) {
        System.out.println("\n--- Create Savings Account ---");
        System.out.print("Enter initial balance (min Rs. 1000): ");
        double balance = getDoubleInput(scanner);

        try {
            String accNo = "SAV" + (++accNumberCounter);
            SavingsAccount account = new SavingsAccount(accNo, balance);
            customer.addAccount(account);
            System.out.println("Savings Account created successfully!");
            System.out.println("Account Number: " + accNo);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void depositMoney(Scanner scanner, Customer customer) {
        System.out.println("\n--- Deposit Money ---");
        Account account = selectAccount(scanner, customer);
        if (account == null) {
            System.out.println("Invalid account selection.");
            return;
        }

        System.out.print("Enter amount to deposit: ");
        double amount = getDoubleInput(scanner);

        try {
            account.deposit(amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void withdrawMoney(Scanner scanner, Customer customer) {
        System.out.println("\n--- Withdraw Money ---");
        Account account = selectAccount(scanner, customer);
        if (account == null) {
            System.out.println("Invalid account selection.");
            return;
        }

        System.out.print("Enter amount to withdraw: ");
        double amount = getDoubleInput(scanner);

        try {
            account.withdraw(amount);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static Customer selectCustomer(Scanner scanner) {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return null;
        }

        System.out.println("\nAvailable Customers:");
        for (int i = 0; i < customers.size(); i++) {
            System.out.println((i + 1) + ". " + customers.get(i).getName() + 
                " (" + customers.get(i).getCustomerId() + ")");
        }
        System.out.print("Select customer (number): ");
        int index = getIntInput(scanner) - 1;

        if (index >= 0 && index < customers.size()) {
            return customers.get(index);
        }
        return null;
    }

    private static Account selectAccount(Scanner scanner, Customer customer) {
        List<Account> accounts = customer.getAccounts();
        if (accounts.isEmpty()) {
            System.out.println("No accounts found.");
            return null;
        }

        System.out.println("\nAvailable Accounts:");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println((i + 1) + ". " + accounts.get(i).getAccountType() + 
                " (" + accounts.get(i).getAccountNumber() + ") - Balance: Rs. " +
                String.format("%.2f", accounts.get(i).getBalance()));
        }
        System.out.print("Select account (number): ");
        int index = getIntInput(scanner) - 1;

        if (index >= 0 && index < accounts.size()) {
            return accounts.get(index);
        }
        return null;
    }

    private static int getIntInput(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static double getDoubleInput(Scanner scanner) {
        try {
            return Double.parseDouble(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static int generateId() {
        return (int) (Math.random() * 10000);
    }
}
