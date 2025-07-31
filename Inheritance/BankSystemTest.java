//Superclass
class BankAccount {
    protected String accountNumber;
    protected double balance;

    //Constructor
    public BankAccount(String accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }
   
    //Method to display details
    public void displayDetails() {
        System.out.println("AccountNumber: " + accountNumber);
        System.out.println("Balance: ₹" + balance);
    }
}

//Subclass Saving Account
class SavingAccount extends BankAccount {
    private double interestRate;

    public SavingAccount(String accountNumber, double balance, double interestRate) {
        super(accountNumber, balance);
        this.interestRate = interestRate;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Saving Account");
        displayDetails();
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

//Subclass checking Account
class CheckingAccount extends BankAccount {
    private double withdrawalLimit;

    public CheckingAccount(String accountNumber, double balance, double withdrawalLimit) {
        super(accountNumber, balance);
        this.withdrawalLimit = withdrawalLimit;
    }
    public void displayAccountType() {
        System.out.println("Account Type: Checking Account");
        displayDetails();
        System.out.println("Withdrawal Limit: ₹" + withdrawalLimit);
    }
}

//Subclass Fixed Deposit Account
class FixedDepositAccount extends BankAccount {
    private int maturityPeriod;

    public FixedDepositAccount(String accountNumber, double balance, int maturityPeriod) {
        super(accountNumber,balance);
        this.maturityPeriod = maturityPeriod;
    }
    public void displayAccountType() {
        System.out.println("Account Type:  + Fixed Deposit Account");
        displayDetails();
        System.out.println("Maturity Period: " + maturityPeriod + "months");
    }
}

//Main class to test
public class BankSystemTest {
    public static void main(String[] args) {
        SavingAccount saving = new SavingAccount("SA123", 10000.0, 4.5);
        CheckingAccount checking = new CheckingAccount("CA456", 15000.0, 5000.0);
        FixedDepositAccount fd = new FixedDepositAccount("FD789", 50000.0, 12);

        saving.displayAccountType();
        System.out.println();
        checking.displayAccountType();
        System.out.println();
        fd.displayAccountType();
    }
}
















