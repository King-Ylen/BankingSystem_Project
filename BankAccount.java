public class BankAccount {
    private String accountNumber;
    private String owner;
    private double balance;
    private String password;

    public BankAccount(String accountNumber, String owner, double balance, String password) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = balance;
        this.password = password;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public String getPassword() {
        return password;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: " + amount);
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
        } else {
            System.out.println("Insufficient balance!");
        }
    }

    public boolean checkPassword(String input) {
        return password.equals(input);
    }
}