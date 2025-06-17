import java.util.Scanner;
class OddEvenArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a natural number (positive integer): ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Error: Please enter a natural number (greater than 0).");
            return;
        }

        int size = number / 2 + 1;
        int[] evenArray = new int[size];
        int[] oddArray = new int[size];

        int evenIndex = 0;
        int oddIndex = 0;

        for (int i = 1; i <= number; i++) {
            if (i % 2 == 0) {
                evenArray[evenIndex++] = i;
            } else {
                oddArray[oddIndex++] = i;
            }
        }

        System.out.print("Even numbers: ");
        for (int i = 0; i < evenIndex; i++) {
            System.out.print(evenArray[i] + " ");
        }

        System.out.println();

        System.out.print("Odd numbers: ");
        for (int i = 0; i < oddIndex; i++) {
            System.out.print(oddArray[i] + " ");
        }

        scanner.close();
    }
}
