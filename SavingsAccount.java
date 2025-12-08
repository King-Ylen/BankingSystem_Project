public class SavingsAccount extends BankAccount {

    private double interestRate;

    public SavingsAccount(String accountNumber, String owner, double balance, double interestRate, String password) {
        super(accountNumber, owner, balance, password);
        this.interestRate = interestRate;
    }

    public void applyInterest() {
        double interest = getBalance() * interestRate;
        deposit(interest);
        System.out.println("================================");
        System.out.println("Interest added: " + interest);
        System.out.println("================================");
    }
}