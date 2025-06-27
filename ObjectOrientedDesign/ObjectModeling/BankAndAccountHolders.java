import java.util.ArrayList;

// Main class
class BankAssociationDemo {

    // Bank class
    static class Bank {
        private String bankName;
        private ArrayList<Customer> customers;

        public Bank(String bankName) {
            this.bankName = bankName;
            this.customers = new ArrayList<>();
        }

        // Open a new account for a customer
        public void openAccount(Customer customer, String accountType, double initialBalance) {
            BankAccount newAccount = new BankAccount(this, accountType, initialBalance);
            customer.addAccount(newAccount);
            if (!customers.contains(customer)) {
                customers.add(customer);
            }
            System.out.println("Account opened for " + customer.getName() + " at " + bankName);
        }

        public String getBankName() {
            return bankName;
        }
    }

    // Customer class
    static class Customer {
        private String name;
        private ArrayList<BankAccount> accounts;

        public Customer(String name) {
            this.name = name;
            this.accounts = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        public void addAccount(BankAccount account) {
            accounts.add(account);
        }

        // View balance of all accounts
        public void viewBalance() {
            System.out.println("Customer: " + name);
            for (BankAccount account : accounts) {
                System.out.println("Bank: " + account.getBank().getBankName() +
                        ", Account Type: " + account.getAccountType() +
                        ", Balance: ₹" + account.getBalance());
            }
            System.out.println();
        }
    }

    // BankAccount class
    static class BankAccount {
        private Bank bank;
        private String accountType;
        private double balance;

        public BankAccount(Bank bank, String accountType, double balance) {
            this.bank = bank;
            this.accountType = accountType;
            this.balance = balance;
        }

        public Bank getBank() {
            return bank;
        }

        public String getAccountType() {
            return accountType;
        }

        public double getBalance() {
            return balance;
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create banks
        Bank sbi = new Bank("SBI Bank");
        Bank hdfc = new Bank("HDFC Bank");

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Open accounts
        sbi.openAccount(alice, "Savings", 5000);
        sbi.openAccount(bob, "Current", 10000);
        hdfc.openAccount(alice, "Fixed Deposit", 20000);

        // View balances
        alice.viewBalance();
        bob.viewBalance();
    }
}
