import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {
    private static int transactionCounter = 1000;
    private String transactionId;
    private double amount;
    private String type; // DEPOSIT, WITHDRAWAL, EMI_PAYMENT
    private LocalDateTime dateTime;
    private String description;

    public Transaction(double amount, String type, String description) {
        this.transactionId = "TXN" + (++transactionCounter);
        this.amount = amount;
        this.type = type;
        this.dateTime = LocalDateTime.now();
        this.description = description;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public String getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("ID: %s | Type: %-12s | Amount: Rs. %8.2f | Date: %s | Desc: %s",
                transactionId, type, amount, dateTime.format(formatter), description);
    }
}
