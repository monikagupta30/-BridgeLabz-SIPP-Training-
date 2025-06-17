import java.util.Scanner;
class ArraySum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] numbers = new double[10];
        double total = 0.0;
        int index = 0;

        while (true) {
            System.out.print("Enter a number (0 or negative to stop): ");
            double input = scanner.nextDouble();


            if (input <= 0) {
                break;
            }

            if (index == 10) {
                System.out.println("Maximum of 10 values reached.");
                break;
            }

            numbers[index++] = input;
        }

        System.out.print("You entered: ");
        for (int i = 0; i < index; i++) {
            System.out.print(numbers[i] + " ");
            total += numbers[i];
        }

        System.out.println("\nTotal sum of entered numbers: " + total);

        scanner.close();
    }
}
