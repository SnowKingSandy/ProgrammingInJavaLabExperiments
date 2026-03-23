public class SavingsAccount extends Account {
    private static final double MIN_BALANCE = 1000;
    private static final double INTEREST_RATE = 4.0; // 4% per annum
    private double minimumBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, double initialBalance) {
        super(accountNumber, "SAVINGS ACCOUNT", initialBalance);
        if (initialBalance < MIN_BALANCE) {
            throw new IllegalArgumentException("Minimum balance required: Rs. " + MIN_BALANCE);
        }
        this.minimumBalance = MIN_BALANCE;
        this.interestRate = INTEREST_RATE;
    }

    public double getMinimumBalance() {
        return minimumBalance;
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!");
        }
        balance += amount;
        transactions.add(new Transaction(amount, "DEPOSIT", "Deposit to Savings Account"));
        System.out.println("Deposit successful! Amount: Rs. " + String.format("%.2f", amount));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
    }

    @Override
    public void withdraw(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive!");
        }
        if (amount > balance) {
            throw new IllegalArgumentException("Insufficient balance! Available: Rs. " + 
                String.format("%.2f", balance));
        }
        if ((balance - amount) < minimumBalance) {
            throw new IllegalArgumentException("Cannot withdraw! Minimum balance of Rs. " + 
                minimumBalance + " must be maintained.");
        }
        balance -= amount;
        transactions.add(new Transaction(amount, "WITHDRAWAL", "Withdrawal from Savings Account"));
        System.out.println("Withdrawal successful! Amount: Rs. " + String.format("%.2f", amount));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
    }

    public void calculateInterest() {
        double interest = (balance * interestRate) / 100;
        balance += interest;
        transactions.add(new Transaction(interest, "INTEREST_CREDIT", 
            "Annual Interest Credit (" + interestRate + "%)"));
        System.out.println("Interest calculated and credited!");
        System.out.println("  Interest Amount: Rs. " + String.format("%.2f", interest));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Minimum Balance: Rs. " + String.format("%.2f", minimumBalance));
        System.out.println("Interest Rate: " + interestRate + "% p.a.");
    }
}
