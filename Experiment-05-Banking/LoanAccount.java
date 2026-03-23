public class LoanAccount extends Account {
    private String loanType; // Personal, Home, Auto, Education
    private double principalAmount;
    private double interestRate;
    private int tenureMonths;
    private int remainingMonths;
    private double emiAmount;
    private double totalInterestPayable;
    private double amountPaid;

    public LoanAccount(String accountNumber, String loanType, double principalAmount, 
                       double interestRate, int tenureMonths) {
        super(accountNumber, "LOAN ACCOUNT (" + loanType + ")", principalAmount);
        this.loanType = loanType;
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.tenureMonths = tenureMonths;
        this.remainingMonths = tenureMonths;
        this.calculateEMI();
        this.amountPaid = 0;
    }

    private void calculateEMI() {
        // EMI = P * [r(1+r)^n] / [(1+r)^n - 1]
        // where P = Principal, r = monthly rate, n = tenure
        double monthlyRate = interestRate / 100 / 12;
        double numerator = principalAmount * monthlyRate * Math.pow(1 + monthlyRate, tenureMonths);
        double denominator = Math.pow(1 + monthlyRate, tenureMonths) - 1;
        this.emiAmount = numerator / denominator;
        this.totalInterestPayable = (emiAmount * tenureMonths) - principalAmount;
    }

    public String getLoanType() {
        return loanType;
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getTenureMonths() {
        return tenureMonths;
    }

    public int getRemainingMonths() {
        return remainingMonths;
    }

    public double getEMIAmount() {
        return emiAmount;
    }

    public double getTotalInterestPayable() {
        return totalInterestPayable;
    }

    public double getAmountPaid() {
        return amountPaid;
    }

    public double getRemainingAmount() {
        return (emiAmount * remainingMonths);
    }

    @Override
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Deposit amount must be positive!");
        }
        balance += amount;
        transactions.add(new Transaction(amount, "DEPOSIT", "Payment towards Loan Account"));
        System.out.println("Payment received! Amount: Rs. " + String.format("%.2f", amount));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw from a Loan Account!");
    }

    public void payEMI() {
        if (remainingMonths <= 0) {
            System.out.println("Loan already fully paid!");
            return;
        }
        if (balance < emiAmount) {
            System.out.println("Insufficient balance to pay EMI!");
            System.out.println("  Required: Rs. " + String.format("%.2f", emiAmount));
            System.out.println("  Available: Rs. " + String.format("%.2f", balance));
            return;
        }
        
        balance -= emiAmount;
        remainingMonths--;
        amountPaid += emiAmount;
        transactions.add(new Transaction(emiAmount, "EMI_PAYMENT", 
            "EMI Payment - Month " + (tenureMonths - remainingMonths) + " of " + tenureMonths));
        
        System.out.println("EMI Payment successful!");
        System.out.println("  Amount Paid: Rs. " + String.format("%.2f", emiAmount));
        System.out.println("  Remaining Months: " + remainingMonths);
        System.out.println("  Remaining Amount: Rs. " + String.format("%.2f", getRemainingAmount()));
        System.out.println("  New Balance: Rs. " + String.format("%.2f", balance));
    }

    public void displayLoanDetails() {
        System.out.println("\n--- LOAN ACCOUNT DETAILS ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Loan Type: " + loanType);
        System.out.println("Principal Amount: Rs. " + String.format("%.2f", principalAmount));
        System.out.println("Interest Rate: " + interestRate + "% p.a.");
        System.out.println("Tenure: " + tenureMonths + " months");
        System.out.println("Monthly EMI: Rs. " + String.format("%.2f", emiAmount));
        System.out.println("Total Interest Payable: Rs. " + String.format("%.2f", totalInterestPayable));
        System.out.println("Amount Paid: Rs. " + String.format("%.2f", amountPaid));
        System.out.println("Remaining Amount: Rs. " + String.format("%.2f", getRemainingAmount()));
        System.out.println("Remaining Months: " + remainingMonths);
        System.out.println("Current Balance: Rs. " + String.format("%.2f", balance));
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Loan Type: " + loanType);
        System.out.println("Principal: Rs. " + String.format("%.2f", principalAmount));
        System.out.println("Monthly EMI: Rs. " + String.format("%.2f", emiAmount));
        System.out.println("Remaining Months: " + remainingMonths);
    }
}
