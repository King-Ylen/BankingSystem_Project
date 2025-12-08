import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static SavingsAccount findAccount(ArrayList<SavingsAccount> accounts, String accNum) {
        for (SavingsAccount acc : accounts) {
            if (acc.getAccountNumber().equals(accNum)) {
                return acc;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<SavingsAccount> accounts = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n=== BANKOOOOOOOO ===");
            System.out.println("1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. List All Accounts");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.println("================================");
                    System.out.print("Enter account number: ");
                    String num = sc.nextLine();

                    System.out.print("Set your password: ");
                    String pass = sc.nextLine();

                    System.out.print("Enter owner name: ");
                    String owner = sc.nextLine();

                    System.out.print("Enter starting balance: ");
                    double bal = sc.nextDouble();

                    SavingsAccount newAcc = new SavingsAccount(num, owner, bal, 0.05, pass);
                    accounts.add(newAcc);
                    System.out.println("================================");
                    System.out.println("Account created successfully!");
                    System.out.println("================================");
                    break;

                case 2:
                    System.out.println("================================");
                    System.out.print("Enter account number: ");
                    String searchNum = sc.nextLine();

                    System.out.print("Enter password: ");
                    String searchPass = sc.nextLine();
                    System.out.println("================================");

                    SavingsAccount acc = findAccount(accounts, searchNum);

                    if (acc == null) {
                        System.out.println("================================");
                        System.out.println("Account not found!");
                        System.out.println("================================");
                    }
                    if (!acc.checkPassword(searchPass)) {
                        System.out.println("================================");
                        System.out.println("Incorrect Password!");
                        System.out.println("================================");
                        break;
                    } else {
                        int subChoice;
                        do {
                            System.out.println("\n=== ACCOUNT MENU ===");
                            System.out.println("Owner: " + acc.getOwner());
                            System.out.println("1. View Balance");
                            System.out.println("2. Deposit");
                            System.out.println("3. Withdraw");
                            System.out.println("4. Apply Interest");
                            System.out.println("5. Back");
                            System.out.print("Choose: ");
                            subChoice = sc.nextInt();

                            switch (subChoice) {
                                case 1:
                                    System.out.println("================================");
                                    System.out.println("Balance: " + acc.getBalance());
                                    System.out.println("================================");
                                    break;
                                case 2:
                                    System.out.println("================================");
                                    System.out.print("Enter amount: ");
                                    acc.deposit(sc.nextDouble());
                                    System.out.println("================================");
                                    break;
                                case 3:
                                    System.out.println("================================");
                                    System.out.print("Enter amount: ");
                                    acc.withdraw(sc.nextDouble());
                                    System.out.println("================================");
                                    break;
                                case 4:
                                    acc.applyInterest();
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("================================");
                                    System.out.println("Invalid choice!");
                                    System.out.println("================================");
                            }

                        } while (subChoice != 5);
                    }
                    break;

                case 3:

                    int devPass = 4753;
                    System.out.print("Password: ");
                    int inDevPass = sc.nextInt();

                    if (inDevPass == devPass) {
                        System.out.println("\n=== LIST OF ACCOUNTS ===");
                        if (accounts.isEmpty()) {
                            System.out.println("No accounts yet.");
                        } else {
                            for (SavingsAccount a : accounts) {
                                System.out.println("Account: " + a.getAccountNumber() +
                                        " | Owner: " + a.getOwner() +
                                        " | Balance: " + a.getBalance() +
                                        " | Password: " + a.getPassword());
                            }
                        }
                    } else {
                        System.out.println("================================");
                        System.out.println("You're not allowed to open this!");
                        System.out.println("================================");
                    }

                    break;

                case 4:
                    System.out.println("================================");
                    System.out.println("Thank you for using the bank!");
                    System.out.println("================================");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}