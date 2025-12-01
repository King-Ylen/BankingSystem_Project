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
            System.out.println("\n=== BANK SYSTEM ===");
            System.out.println("1. Create Account");
            System.out.println("2. Access Account");
            System.out.println("3. List All Accounts");
            System.out.println("4. Exit");
            System.out.print("Choose: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
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

                    System.out.println("Account created successfully!");
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String searchNum = sc.nextLine();

                    System.out.print("Enter password: ");
                    String searchPass = sc.nextLine();

                    SavingsAccount acc = findAccount(accounts, searchNum);

                    if (acc == null) {
                        System.out.println("Account not found!");
                    } if (!acc.checkPassword(searchPass)) {
                        System.out.println("Incorrect Password!");
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
                                    System.out.println("Balance: " + acc.getBalance());
                                    break;
                                case 2:
                                    System.out.print("Enter amount: ");
                                    acc.deposit(sc.nextDouble());
                                    break;
                                case 3:
                                    System.out.print("Enter amount: ");
                                    acc.withdraw(sc.nextDouble());
                                    break;
                                case 4:
                                    acc.applyInterest();
                                    break;
                                case 5:
                                    break;
                                default:
                                    System.out.println("Invalid choice!");
                            }

                        } while (subChoice != 5);
                    }
                    break;

                case 3:
                    System.out.println("\n=== LIST OF ACCOUNTS ===");
                    if (accounts.isEmpty()) {
                        System.out.println("No accounts yet.");
                    } else {
                        for (SavingsAccount a : accounts) {
                            System.out.println("Account: " + a.getAccountNumber() +
                                    " | Owner: " + a.getOwner() +
                                    " | Balance: " + a.getBalance());
                        }
                    }
                    break;

                case 4:
                    System.out.println("Thank you for using the bank!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 4);

        sc.close();
    }
}