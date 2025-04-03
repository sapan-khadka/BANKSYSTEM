// src/BankOperations.java
import java.util.ArrayList;
import java.util.Scanner;

public class BankOperations {
    private ArrayList<BankAccount> accounts;
    private Scanner scanner;

    public BankOperations() {
        this.accounts = FileHandler.loadAccounts();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        while (true) {
            System.out.println("\n===== BANK SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. View Transaction History");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1: createAccount(); break;
                case 2: deposit(); break;
                case 3: withdraw(); break;
                case 4: checkBalance(); break;
                case 5: viewTransactions(); break;
                case 6: 
                    FileHandler.saveAccounts(accounts);
                    System.out.println("Goodbye!");
                    return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private void createAccount() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        System.out.print("Enter account holder name: ");
        String name = scanner.nextLine();
        System.out.print("Enter initial deposit: $");
        double deposit = scanner.nextDouble();

        BankAccount newAccount = new BankAccount(accNum, name, deposit);
        accounts.add(newAccount);
        System.out.println("Account created successfully!");
    }

    private void deposit() {
        BankAccount account = findAccount();
        if (account == null) return;

        System.out.print("Enter deposit amount: $");
        double amount = scanner.nextDouble();
        account.deposit(amount);
        System.out.println("Deposit successful!");
    }

    private void withdraw() {
        BankAccount account = findAccount();
        if (account == null) return;

        System.out.print("Enter withdrawal amount: $");
        double amount = scanner.nextDouble();
        try {
            account.withdraw(amount);
            System.out.println("Withdrawal successful!");
        } catch (InsufficientFundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private void checkBalance() {
        BankAccount account = findAccount();
        if (account == null) return;
        System.out.printf("Current balance: $%.2f\n", account.getBalance());
    }

    private void viewTransactions() {
        BankAccount account = findAccount();
        if (account == null) return;
        
        System.out.println("\n=== Transaction History ===");
        for (String transaction : account.getTransactionHistory()) {
            System.out.println(transaction);
        }
    }

    private BankAccount findAccount() {
        System.out.print("Enter account number: ");
        String accNum = scanner.nextLine();
        
        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accNum)) {
                return account;
            }
        }
        
        System.out.println("Account not found!");
        return null;
    }
}