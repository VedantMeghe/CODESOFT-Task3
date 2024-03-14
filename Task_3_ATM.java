
import java.util.Scanner;

class BankAccount {
    private double balance;

    public BankAccount(double initialBalance) {
        balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Rs." + amount + " successful Deposit ");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println("Rs" + amount + " successfully Withdrawal");
            return true;
        } else {
            System.out.println("Insufficient Balance.");
            return false;
        }
    }
}

public class Task_3_ATM {
    private BankAccount account;

    public Task_3_ATM(BankAccount account) {
        this.account = account;
    }

    public void displayOptions() {
        System.out.println("\nATM Menu:");
        System.out.println("1. Check Balance");
        System.out.println("2. Deposit");
        System.out.println("3. Withdraw");
        System.out.println("4. Exit");
    }

    public void processTransaction(int choice, Scanner scanner) {
        switch (choice) {
            case 1:
                System.out.println("Your current balance is: Rs." + account.getBalance());
                break;
            case 2:
                System.out.print("Enter deposit amount: Rs.");
                double depositAmount = scanner.nextDouble();
                account.deposit(depositAmount);
                break;
            case 3:
                System.out.print("Enter withdrawal amount: Rs.");
                double withdrawAmount = scanner.nextDouble();
                if (account.withdraw(withdrawAmount)) {
                    System.out.println("Please take your cash.");
                }
                break;

            default:
                System.out.println("Invalid option. Please try again.");
        }
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount(1000.0); // Initial balance $1000
        Task_3_ATM atm = new Task_3_ATM(userAccount);
        Scanner scanner = new Scanner(System.in);

        while (true) {
            atm.displayOptions();
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            atm.processTransaction(choice, scanner);
        }
    }
}
