public class CurrentAccount extends Account {
    private double overdraftLimit;
    private double chequeBookFee;
    private boolean overdraftFacilityEnabled;

    public CurrentAccount(String accountNumber, double initialBalance) {
        super(accountNumber, "CURRENT ACCOUNT", initialBalance);
        this.overdraftLimit = initialBalance * 0.25; // 25% of initial balance
        this.chequeBookFee = 100;
        this.overdraftFacilityEnabled = true;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    public double getAvailableBalance() {
        if (overdraftFacilityEnabled) {
            return balance + overdraftLimit;
        }
        return balance;
    }

    public boolean isOverdraftFacilityEnabled() {
        return overdraftFacilityEnabled;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!");
        }
        balance += amount;
        transactions.add(new Transaction(amount, "DEPOSIT", "Deposit to Current Account"));
        System.out.println("Deposit successful! Amount: Rs. " + String.format("%.2f", amount));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
        System.out.println("  Available Balance (incl. Overdraft): Rs. " + 
            String.format("%.2f", getAvailableBalance()));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive!");
        }
        if (overdraftFacilityEnabled) {
            if (amount > getAvailableBalance()) {
                throw new IllegalArgumentException("Insufficient balance! Available: Rs. " + 
                    String.format("%.2f", getAvailableBalance()));
            }
        } else {
            if (amount > balance) {
                throw new IllegalArgumentException("Insufficient balance! Available: Rs. " + 
                    String.format("%.2f", balance));
            }
        }
        balance -= amount;
        transactions.add(new Transaction(amount, "WITHDRAWAL", "Withdrawal from Current Account"));
        System.out.println("Withdrawal successful! Amount: Rs. " + String.format("%.2f", amount));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
        if (balance < 0) {
            System.out.println("  Overdraft Used: Rs. " + String.format("%.2f", Math.abs(balance)));
        }
    }

    public void requestChequeBook() {
        if (balance >= chequeBookFee) {
            balance -= chequeBookFee;
            transactions.add(new Transaction(chequeBookFee, "FEE", "Cheque Book Fee"));
            System.out.println("Cheque book requested! Fee: Rs. " + String.format("%.2f", chequeBookFee));
            System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
        } else {
            System.out.println("Insufficient balance to request cheque book!");
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Overdraft Limit: Rs. " + String.format("%.2f", overdraftLimit));
        System.out.println("Available Balance (incl. Overdraft): Rs. " + 
            String.format("%.2f", getAvailableBalance()));
        System.out.println("Overdraft Facility: " + (overdraftFacilityEnabled ? "Enabled" : "Disabled"));
    }
}
