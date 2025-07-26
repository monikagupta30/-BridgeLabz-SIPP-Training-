import java.util.*;

public class BankingSystem {
    public static void main(String[] args) {
        // 1. HashMap to store customer accounts
        Map<Integer, Double> accounts = new HashMap<>();
        accounts.put(101, 5000.0);
        accounts.put(102, 12000.0);
        accounts.put(103, 8000.0);
        accounts.put(104, 1500.0);

        // 2. Queue to process withdrawal requests
        Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();
        withdrawalQueue.offer(new WithdrawalRequest(101, 1000));
        withdrawalQueue.offer(new WithdrawalRequest(103, 3000));
        withdrawalQueue.offer(new WithdrawalRequest(104, 2000)); // should fail
        withdrawalQueue.offer(new WithdrawalRequest(102, 500));

        // Process withdrawals
        System.out.println("🏦 Processing Withdrawals:");
        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest request = withdrawalQueue.poll();
            double currentBalance = accounts.getOrDefault(request.accountNumber, 0.0);
            if (request.amount <= currentBalance) {
                accounts.put(request.accountNumber, currentBalance - request.amount);
                System.out.printf("✅ Withdrawal of ₹%.2f from account %d successful. Remaining: ₹%.2f\n",
                        request.amount, request.accountNumber, currentBalance - request.amount);
            } else {
                System.out.printf("❌ Withdrawal of ₹%.2f from account %d failed. Insufficient balance.\n",
                        request.amount, request.accountNumber);
            }
        }

        // 3. TreeMap to sort accounts by balance
        TreeMap<Double, List<Integer>> sortedByBalance = new TreeMap<>();
        for (Map.Entry<Integer, Double> entry : accounts.entrySet()) {
            double balance = entry.getValue();
            int accNo = entry.getKey();
            sortedByBalance.computeIfAbsent(balance, k -> new ArrayList<>()).add(accNo);
        }

        // Display accounts sorted by balance
        System.out.println("\n📊 Accounts Sorted by Balance:");
        for (Map.Entry<Double, List<Integer>> entry : sortedByBalance.entrySet()) {
            for (int acc : entry.getValue()) {
                System.out.printf("Account %d → ₹%.2f\n", acc, entry.getKey());
            }
        }
    }

    // Helper class for withdrawal requests
    static class WithdrawalRequest {
        int accountNumber;
        double amount;

        WithdrawalRequest(int accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }
    }
}
