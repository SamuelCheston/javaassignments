import java.util.Scanner;
public class bsm {
    public static void main(String[] args) {
        ba account1 = new ba(12345, 100.0, 0.05);
        Scanner scanner = new Scanner(System.in);
        int option;

        while (true) {
        System.out.println("=====Bank system=====");
        System.out.println("1. Account INFO");
        System.out.println("2. DEPOSIT");
        System.out.println("3. WITHDRAW");
        System.out.println("4. CHANGE RATE");
        System.out.println("5. EXIT");
        option = scanner.nextInt();

        if (option == 1) {
            System.out.println("Account Number: " + account1.accNum);
            System.out.println("Account Balance: " + account1.accBal);
            System.out.println("Interest Rate: " + account1.interestRate);
            System.out.println("Date Created: " + account1.dateCreated);
        } else if (option == 2) {
            System.out.print("Enter deposit amount: ");
            double amount = scanner.nextDouble();
            account1.Deposit(amount);
            System.out.println("New Account Balance after deposit: " + account1.accBal);
        } else if (option == 3) {
            System.out.print("Enter withdrawal amount: ");
            double amount = scanner.nextDouble();
            boolean success = account1.Withdraw(amount);
            if (success) {
                System.out.println("New Account Balance after withdrawal: " + account1.accBal);
            }
        } else if (option == 4) {
            System.out.print("Enter new interest rate: ");
            double newRate = scanner.nextDouble();
            account1.EditRate(newRate);
            System.out.println("New Interest Rate: " + account1.interestRate);
        } else if (option == 5) {
            break;
        } else {
            System.out.println("Invalid option. Please try again.");
        }
    }
}
}