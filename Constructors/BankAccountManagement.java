// Base class
class BankAccount {
    public String accountNumber;     // Public – accessible everywhere
    protected String accountHolder;  // Protected – accessible in subclass
    private double balance;          // Private – encapsulated

    // Constructor
    public BankAccount(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    // Getter for balance
    public double getBalance() {
        return balance;
    }

    // Setter for balance
    public void setBalance(double balance) {
        if (balance >= 0) {
            this.balance = balance;
        } else {
            System.out.println("Balance cannot be negative.");
        }
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolder);
        System.out.println("Balance        : ₹" + balance);
        System.out.println();
    }
}

// Subclass
class SavingsAccount extends BankAccount {
    private double interestRate;

    // Constructor
    public SavingsAccount(String accountNumber, String accountHolder, double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    // Display details showing access to public and protected members
    public void displaySavingsAccount() {
        System.out.println("Savings Account:");
        System.out.println("Account Number : " + accountNumber);   // public
        System.out.println("Account Holder : " + accountHolder);   // protected
        System.out.println("Interest Rate  : " + interestRate + "%");
        System.out.println();
    }
}

// Main class
class BankAccountManagement {
    public static void main(String[] args) {
        // Create a BankAccount
        BankAccount b1 = new BankAccount("1234567890", "Amit Verma", 10000.00);
        b1.displayAccountDetails();

        // Update balance
        b1.setBalance(12000.00);
        System.out.println("Updated Balance: ₹" + b1.getBalance());
        System.out.println();

        // Create a SavingsAccount
        SavingsAccount s1 = new SavingsAccount("9876543210", "Sneha Kapoor", 15000.00, 3.5);
        s1.displayAccountDetails();    // inherited
        s1.displaySavingsAccount();    // subclass-specific
    }
}
