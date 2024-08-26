import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BankService bankService = new BankService();
        Scanner sc = new Scanner(System.in);
        int userInput;

        do{
            userInput = bankService.userInput();

            switch (userInput) {
                case 1: // Open account
                    Random rand = new Random();
                    int accountNo = rand.nextInt(10000);
                    System.out.println("Enter Name: ");
                    String name = sc.next();
                    System.out.println("Enter Phone Number: ");
                    String phone = sc.next();
                    System.out.println("Enter Initial Balance: ");
                    double balance = sc.nextDouble();
                    bankService.accountCreated(accountNo, name, phone, balance);
                    break;

                case 2: // Credit
                    System.out.println("Enter Account No: ");
                    int creditAccountNo = sc.nextInt();
                    System.out.println("Enter Amount to Credit: ");
                    double amount = sc.nextDouble();
                    bankService.accountCredit(creditAccountNo, amount);
                    break;

                case 3: // Debit
                    System.out.println("Enter Account No: ");
                    int debitAccountNo = sc.nextInt();
                    System.out.println("Enter Amount to Debit: ");
                    double debitAmount = sc.nextDouble();
                    bankService.accountDebit(debitAccountNo, debitAmount);
                    break;

                case 4: // Print all accounts
                    bankService.printAllAccounts();
                    break;

                case 5: // Close account
                    System.out.println("Enter Account No to Close: ");
                    int closeAccountNo = sc.nextInt();
                    bankService.accountClose(closeAccountNo);
                    break;

                case 6: // Exit
                    System.out.println("Exiting... Thank you!");
                    break;

                default:
                    System.out.println("Enter a valid option!");
                    break;
            }
        }while(userInput!=6);
    }
}