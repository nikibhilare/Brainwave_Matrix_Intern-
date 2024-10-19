import java.util.Scanner;

public class ATMInterface {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Sample user data 
        String[] userNames = {"user1", "user2"};
        int[] userPINs = {1234, 5678};
        double[] userBalances = {1000.0, 2000.0};

        // ATM authentication
        System.out.print("Enter your username: ");
        String username = scanner.nextLine();

        int index = -1;
        for (int i = 0; i < userNames.length; i++) {
            if (userNames[i].equals(username)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("Invalid username. Please try again.");
            return;
        }

        System.out.print("Enter your PIN: ");
        int pin = scanner.nextInt();

        if (pin != userPINs[index]) {
            System.out.println("Invalid PIN. Please try again.");
            return;
        }

        System.out.println("Welcome, " + username + "!");

        // ATM menu
        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Check balance");
            System.out.println("2. Withdraw cash");
            System.out.println("3. Deposit cash");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Your current balance is: $" + userBalances[index]);
                    break;
                case 2:
                    System.out.print("Enter the amount to withdraw: $");
                    double withdrawalAmount = scanner.nextDouble();
                    if (withdrawalAmount > userBalances[index]) {
                        System.out.println("Insufficient funds.");
                    } else {
                        userBalances[index] -= withdrawalAmount;
                        System.out.println("Withdrawal successful. Your new balance is: $" + userBalances[index]);
                    }
                    break;
                case 3:
                    System.out.print("Enter the amount to deposit: $");
                    double depositAmount = scanner.nextDouble();
                    userBalances[index] += depositAmount;
                    System.out.println("Deposit successful. Your new balance is: $" + userBalances[index]);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}