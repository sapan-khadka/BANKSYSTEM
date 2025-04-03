// src/FileHandler.java
import java.io.*;
import java.util.ArrayList;

public class FileHandler {
    private static final String FILE_NAME = "accounts.dat";

    public static void saveAccounts(ArrayList<BankAccount> accounts) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            oos.writeObject(accounts);
        } catch (IOException e) {
            System.out.println("Error saving accounts: " + e.getMessage());
        }
    }

    public static ArrayList<BankAccount> loadAccounts() {
        File file = new File(FILE_NAME);
        if (!file.exists()) {
            return new ArrayList<>();
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            return (ArrayList<BankAccount>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error loading accounts: " + e.getMessage());
            return new ArrayList<>();
        }
    }
}