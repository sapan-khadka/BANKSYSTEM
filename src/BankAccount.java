// src/BankAccount.java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class BankAccount {
    private String accountNumber;
    private String accountHolder;
    private double balance;
    private ArrayList<String> transactionHistory;

    public BankAccount(String accountNumber, String accountHolder, double initialDeposit) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = initialDeposit;
        this.transactionHistory = new ArrayList<>();
        addTransaction("Account created with initial deposit: $" + initialDeposit);
    }

    // Getters
    public String getAccountNumber() { return accountNumber; }
    public String getAccountHolder() { return accountHolder; }
    public double getBalance() { return balance; }
    public ArrayList<String> getTransactionHistory() { return transactionHistory; }

    // Account operations
    public void deposit(double amount) {
        balance += amount;
        addTransaction("Deposit: +$" + amount);
    }

    public void withdraw(double amount) throws InsufficientFundsException {
        if (amount > balance) {
            throw new InsufficientFundsException("Not enough money in account!");
        }
        balance -= amount;
        addTransaction("Withdrawal: -$" + amount);
    }

    private void addTransaction(String message) {
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        transactionHistory.add(timestamp + " - " + message);
    }
}