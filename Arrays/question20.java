import java.util.Scanner;
class ReverseNumberArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a positive number: ");
        int number = scanner.nextInt();

        if (number < 0) {
            System.out.println("Invalid input. Please enter a positive number.");
            return;
        }

        int temp = number;
        int[] digits = new int[10]; 
        int count = 0;

        if (number == 0) {
            digits[count++] = 0;
        } else {
            while (temp != 0) {
                digits[count++] = temp % 10; 
                temp /= 10;
            }
        }

        System.out.print("Reversed number is: ");
        for (int i = 0; i < count; i++) {
            System.out.print(digits[i]);
        }

        scanner.close();
    }
}
