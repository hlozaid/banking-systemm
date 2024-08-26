import java.util.Map;
import java.util.HashMap;
import java.util.Scanner;

public class BankService {
    private Map<Integer, PersonInfo> accountMap = new HashMap<>();

    // Method to create an account
    public void accountCreated(int accountNo, String name, String phoneNumber, double balance) {
        PersonInfo personInfo = new PersonInfo();
        personInfo.setPersonName(name);
        personInfo.setPersonPhone(phoneNumber);
        personInfo.setBalance(balance);
        accountMap.put(accountNo, personInfo);
    }

    // Method to credit an account
    public double accountCredit(int accountNo, double amount) {
        PersonInfo person = accountMap.get(accountNo);
        if (person != null) {
            person.setBalance(person.getBalance() + amount);
            System.out.println("Account credit successful. New Balance: " + person.getBalance());
            return person.getBalance();
        } else {
            System.out.println("Account not found.");
            return 0;
        }
    }

    // Method to debit an account
    public double accountDebit(int accountNo, double amount) {
        PersonInfo person = accountMap.get(accountNo);
        if (person != null) {
            if (person.getBalance() >= amount) {
                person.setBalance(person.getBalance() - amount);
                System.out.println("Account debit successful. New Balance: " + person.getBalance());
                return person.getBalance();
            } else {
                System.out.println("Insufficient balance.");
                return person.getBalance();
            }
        } else {
            System.out.println("Account not found.");
            return 0;
        }
    }

    // Method to close an account
    public void accountClose(int accountNo) {
        if (accountMap.remove(accountNo) != null) {
            System.out.println("Account close successful.");
        } else {
            System.out.println("Account not found.");
        }
    }

    // Method to print all accounts
    public void printAllAccounts() {
        for (Map.Entry<Integer, PersonInfo> entry : accountMap.entrySet()) {
            System.out.println("Account Number: " + entry.getKey() + " --> " + entry.getValue());
        }
    }

    // Method to get user input for menu options
    public int userInput() {
        System.out.println("Please select an option:");
        System.out.println("1. Open Account\n2. Credit Account\n3. Debit Account\n4. Print All Account Holders\n5. Close Account\n6. Exit");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
