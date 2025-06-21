import java.util.Scanner;

class GCDLCMCalculator {

    public static void main(String[] args) {
        int[] inputs = getInput();
        int a = inputs[0];
        int b = inputs[1];

        int gcd = calculateGCD(a, b);
        int lcm = calculateLCM(a, b, gcd);

        displayResults(a, b, gcd, lcm);
    }

    public static int[] getInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();
        scanner.close();

        return new int[]{num1, num2};
    }

    public static int calculateGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a); // Ensure GCD is non-negative
    }

    public static int calculateLCM(int a, int b, int gcd) {
        return Math.abs(a * b) / gcd; // Avoid negative or zero division
    }

    public static void displayResults(int a, int b, int gcd, int lcm) {
        System.out.println("GCD of " + a + " and " + b + " is: " + gcd);
        System.out.println("LCM of " + a + " and " + b + " is: " + lcm);
    }
}
