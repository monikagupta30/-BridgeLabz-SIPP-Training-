import java.util.Scanner;

class FibonacciGenerator {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of terms for the Fibonacci sequence: ");
        int terms = scanner.nextInt();

        generateFibonacci(terms);

        scanner.close();
    }

    public static void generateFibonacci(int n) {
        if (n <= 0) {
            System.out.println("Please enter a positive number.");
            return;
        }

        int first = 0, second = 1;

        System.out.println("Fibonacci sequence up to " + n + " terms:");
        for (int i = 1; i <= n; i++) {
            System.out.print(first + " ");

            int next = first + second;
            first = second;
            second = next;
        }

        System.out.println(); // for a newline after sequence
    }
}
