import java.util.Scanner;

public class NestedTryCatchDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = {10, 20, 30, 40, 50};

        try {
            // Outer try block for array access
            System.out.print("Enter array index: ");
            int index = scanner.nextInt();

            try {
                // Inner try block for division
                System.out.print("Enter divisor: ");
                int divisor = scanner.nextInt();

                int result = numbers[index] / divisor;
                System.out.println("Result: " + result);

            } catch (ArithmeticException e) {
                System.out.println("Cannot divide by zero!");
            }

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Invalid array index!");
        } finally {
            System.out.println("Program finished.");
            scanner.close();
        }
    }
}
