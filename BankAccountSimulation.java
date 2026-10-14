
import java.util.ArrayList;
import java.util.Scanner;

public class BankAccountSimulation {

    // Bank account class
    static class BankAccount {
        private double balance;
        private ArrayList<String> transactions = new ArrayList<>();

        // Constructor
        BankAccount(double initialBalance) {
            balance = initialBalance;
            transactions.add("Account opened with Rs. " + balance);
        }

        // Deposit money
        void deposit(double amount) {
            if (amount <= 0) {
                System.out.println("Enter a valid deposit amount.");
                return;
            }

            balance += amount;
            transactions.add("Deposited Rs. " + amount);
            System.out.println("Deposit successful!");
        }

        // Withdraw money
        void withdraw(double amount) {
            if (amount <= 0) {
                System.out.println("Enter a valid withdrawal amount.");
            } else if (amount > balance) {
                System.out.println("Insufficient balance!");
            } else {
                balance -= amount;
                transactions.add("Withdrawn Rs. " + amount);
                System.out.println("Withdrawal successful!");
            }
        }

        // Display current balance
        void checkBalance() {
            System.out.printf("Current Balance: Rs. %.2f%n", balance);
        }

        // Display transaction history
        void showTransactions() {
            System.out.println("\n--- Transaction History ---");

            for (String transaction : transactions) {
                System.out.println(transaction);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankAccount account = new BankAccount(1000.00);

        int choice = 0;

        do {
            System.out.println("\n===== BANK ACCOUNT MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. View Transaction History");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input! Enter a number.");
                sc.next();
                continue;
            }

            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: Rs. ");
                    if (sc.hasNextDouble()) {
                        account.deposit(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 2:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    if (sc.hasNextDouble()) {
                        account.withdraw(sc.nextDouble());
                    } else {
                        System.out.println("Invalid amount!");
                        sc.next();
                    }
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showTransactions();
                    break;

                case 5:
                    System.out.println("Thank you for using our banking system!");
                    break;

                default:
                    System.out.println("Invalid choice! Select 1 to 5.");
            }

        } while (choice != 5);

        sc.close();
    }
}
