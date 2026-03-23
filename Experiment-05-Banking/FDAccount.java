import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class FDAccount extends Account {
    private double principalAmount;
    private double interestRate;
    private int durationMonths;
    private int remainingMonths;
    private double maturityAmount;
    private LocalDateTime maturityDate;
    private boolean isMatured;

    public FDAccount(String accountNumber, double principalAmount, 
                     double interestRate, int durationMonths) {
        super(accountNumber, "FIXED DEPOSIT ACCOUNT", principalAmount);
        if (principalAmount < 5000) {
            throw new IllegalArgumentException("Minimum FD amount is Rs. 5000");
        }
        this.principalAmount = principalAmount;
        this.interestRate = interestRate;
        this.durationMonths = durationMonths;
        this.remainingMonths = durationMonths;
        this.maturityDate = createdDate.plusMonths(durationMonths);
        this.isMatured = false;
        this.calculateMaturityAmount();
    }

    private void calculateMaturityAmount() {
        // Simple Interest: A = P * (1 + (r * t / 100))
        // where P = Principal, r = rate per annum, t = time in years
        double timeYears = durationMonths / 12.0;
        this.maturityAmount = principalAmount * (1 + (interestRate * timeYears / 100));
    }

    public double getPrincipalAmount() {
        return principalAmount;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public int getDurationMonths() {
        return durationMonths;
    }

    public int getRemainingMonths() {
        return remainingMonths;
    }

    public double getMaturityAmount() {
        return maturityAmount;
    }

    public double getExpectedInterest() {
        return maturityAmount - principalAmount;
    }

    public LocalDateTime getMaturityDate() {
        return maturityDate;
    }

    public boolean isMatured() {
        return isMatured;
    }

    @Override
    public void deposit(double amount) {
        throw new UnsupportedOperationException("Cannot deposit in a Matured FD Account!");
    }

    @Override
    public void withdraw(double amount) {
        throw new UnsupportedOperationException("Cannot withdraw before FD matures!");
    }

    public void checkMaturity() {
        if (LocalDateTime.now().isAfter(maturityDate) || LocalDateTime.now().isEqual(maturityDate)) {
            isMatured = true;
            remainingMonths = 0;
            System.out.println("Your FD has matured!");
        } else {
            System.out.println("FD has not matured yet!");
            System.out.println("  Days remaining: " + calculateDaysRemaining());
        }
    }

    private long calculateDaysRemaining() {
        return ChronoUnit.DAYS.between(LocalDateTime.now(), maturityDate);
    }

    public void redeemFD() {
        checkMaturity();
        if (isMatured) {
            double interestAmount = getExpectedInterest();
            System.out.println("\nFD Redeemed Successfully!");
            System.out.println("  Principal Amount: Rs. " + String.format("%.2f", principalAmount));
            System.out.println("  Interest Earned: Rs. " + String.format("%.2f", interestAmount));
            System.out.println("  Total Amount: Rs. " + String.format("%.2f", maturityAmount));
            balance = maturityAmount;
            transactions.add(new Transaction(maturityAmount, "REDEMPTION", 
                "FD Account Matured and Redeemed"));
        } else {
            System.out.println("Cannot redeem! FD has not matured yet.");
            System.out.println("  Mature on: " + maturityDate);
        }
    }

    public void displayFDDetails() {
        System.out.println("\n--- FIXED DEPOSIT DETAILS ---");
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Principal Amount: Rs. " + String.format("%.2f", principalAmount));
        System.out.println("Interest Rate: " + interestRate + "% p.a.");
        System.out.println("Duration: " + durationMonths + " months");
        System.out.println("Expected Interest: Rs. " + String.format("%.2f", getExpectedInterest()));
        System.out.println("Maturity Amount: Rs. " + String.format("%.2f", maturityAmount));
        System.out.println("Maturity Date: " + maturityDate);
        System.out.println("Status: " + (isMatured ? "MATURED" : "ACTIVE"));
        if (!isMatured) {
            System.out.println("Days Remaining: " + calculateDaysRemaining());
        }
    }

    @Override
    public void displayAccountDetails() {
        super.displayAccountDetails();
        System.out.println("Principal: Rs. " + String.format("%.2f", principalAmount));
        System.out.println("Interest Rate: " + interestRate + "% p.a.");
        System.out.println("Maturity Amount: Rs. " + String.format("%.2f", maturityAmount));
        System.out.println("Status: " + (isMatured ? "MATURED" : "ACTIVE"));
    }
}
