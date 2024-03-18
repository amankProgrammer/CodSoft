import java.util.Scanner;

public class ATM {
    private Bank_Account account;

    // Constructor
    public ATM(Bank_Account account) {
        this.account = account;
    }

    // Method to display the main menu
    public void displayMainMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("ATM Menu:");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            
            // Handle non-integer input
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next(); // Consume invalid input
            }
            
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Current Balance: Rs. " + account.getBalance());
                    break;
                case 2:
                    System.out.print("Enter deposit amount: Rs. ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("!!! Invalid input. Please enter a valid amount. !!!");
                        scanner.next(); 
                    }
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    System.out.println("****** Deposit successful ******");
                    break;
                case 3:
                    System.out.print("Enter withdrawal amount: Rs. ");
                    while (!scanner.hasNextDouble()) {
                        System.out.println("!!! Invalid input. Please enter a valid amount. !!!");
                        scanner.next();
                    }
                    double withdrawAmount = scanner.nextDouble();
                    if (account.withdraw(withdrawAmount)) {
                        System.out.println("****** Withdrawal successful ******");
                    } else {
                        System.out.println("****** Insufficient funds ******");
                    }
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Have a nice day!");
                    break;
                default:
                    System.out.println("!!! Invalid choice. Please try again. !!!");
            }
        } while (choice != 4);

        scanner.close();
    }
}
