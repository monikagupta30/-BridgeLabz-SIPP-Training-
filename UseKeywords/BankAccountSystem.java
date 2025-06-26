class BankAccount {
    // Static variable shared by all instances
    static String bankName = "State Bank of India";
    static int totalAccounts = 0;

    // Final variable - cannot be changed once assigned
    private final int accountNumber;

    // Instance variable
    private String accountHolderName;
    private double balance;

    // Constructor using 'this' keyword
    public BankAccount(int accountNumber, String accountHolderName, double balance) {
        this.accountNumber = accountNumber;               // Resolving ambiguity using 'this'
        this.accountHolderName = accountHolderName;       // Resolving ambiguity using 'this'
        this.balance = balance;
        totalAccounts++;                                  // Increment static counter
    }

    // Static method
    public static void getTotalAccounts() {
        System.out.println("Total Bank Accounts: " + totalAccounts);
    }

    // Method to display account details
    public void displayAccountDetails() {
        System.out.println("Bank Name: " + bankName);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolderName);
        System.out.println("Balance: ₹" + balance);
    }

    // Main method for testing
    public static void main(String[] args) {
        BankAccount acc1 = new BankAccount(1001, "Monika Gupta", 5000);
        BankAccount acc2 = new BankAccount(1002, "Rahul Sharma", 10000);

        // Using instanceof before displaying details
        if (acc1 instanceof BankAccount) {
            acc1.displayAccountDetails();
        }

        if (acc2 instanceof BankAccount) {
            acc2.displayAccountDetails();
        }

        // Calling static method
        BankAccount.getTotalAccounts();
    }
}
