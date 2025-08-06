public class InterestCalculator {

    // Method declaration with 'throws'
    public static double calculateInterest(double amount, double rate, int years) throws IllegalArgumentException {
        // 'throw' to generate exception
        if (amount < 0 || rate < 0) {
            throw new IllegalArgumentException("Amount or rate cannot be negative");
        }

        // Simple interest formula: (P * R * T) / 100
        return (amount * rate * years) / 100;
    }

    public static void main(String[] args) {
        try {
            double amount = 5000;
            double rate = -4.5;  // Invalid rate to test exception
            int years = 3;

            double interest = calculateInterest(amount, rate, years);
            System.out.println("Calculated Interest: " + interest);

        } catch (IllegalArgumentException e) {
            System.out.println("Invalid input: Amount and rate must be positive");
        }
    }
}
