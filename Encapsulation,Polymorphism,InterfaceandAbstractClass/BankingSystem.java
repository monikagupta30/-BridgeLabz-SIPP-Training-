import java.util.*;

// Loanable Interface
interface Loanable {
    void applyForLoan(double amount);
    boolean calculateLoanEligibility();
}

// Abstract class BankAccount
abstract class BankAccount {
    private String accountNumber;
    private String holderName;
    private double balance;

    // Constructor
    public BankAccount(String accountNumber, String holderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = initialBalance;
    }

    // Getters (encapsulation)
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public double getBalance() {
        return balance;
    }

    // Protected setter to update balance
    protected void setBalance(double balance) {
        this.balance = balance;
    }

    // Deposit
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println(holderName + " deposited ₹" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Withdraw
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println(holderName + " withdrew ₹" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }

    // Abstract method
    public abstract double calculateInterest();

    public void displayDetails() {
        System.out.println("Account Holder: " + holderName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

// SavingsAccount class
class SavingsAccount extends BankAccount implements Loanable {
    private double annualInterestRate = 0.04; // 4%

    public SavingsAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * annualInterestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a personal loan of ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 10000;
    }
}

// CurrentAccount class
class CurrentAccount extends BankAccount implements Loanable {
    private double annualInterestRate = 0.01; // 1%

    public CurrentAccount(String accountNumber, String holderName, double initialBalance) {
        super(accountNumber, holderName, initialBalance);
    }

    @Override
    public double calculateInterest() {
        return getBalance() * annualInterestRate;
    }

    @Override
    public void applyForLoan(double amount) {
        System.out.println(getHolderName() + " applied for a business loan of ₹" + amount);
    }

    @Override
    public boolean calculateLoanEligibility() {
        return getBalance() >= 50000;
    }
}

//Main Method
public class BankingSystem {
    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        BankAccount acc1 = new SavingsAccount("SA101", "Ravi", 15000);
        BankAccount acc2 = new CurrentAccount("CA202", "Anjali", 60000);

        accounts.add(acc1);
        accounts.add(acc2);

        for (BankAccount acc : accounts) {
            System.out.println("\n------------------------------");
            acc.displayDetails();
            acc.deposit(2000);
            acc.withdraw(3000);

            double interest = acc.calculateInterest();
            System.out.println("Calculated Interest: ₹" + interest);

            if (acc instanceof Loanable) {
                Loanable loan = (Loanable) acc;
                if (loan.calculateLoanEligibility()) {
                    loan.applyForLoan(50000);
                } else {
                    System.out.println(acc.getHolderName() + " is not eligible for a loan.");
                }
            }
        }
    }
}
