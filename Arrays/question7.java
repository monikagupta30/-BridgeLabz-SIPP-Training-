import java.util.Scanner;
class NumberAnalysis {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] numbers = new int[5];

        System.out.println("Enter 5 numbers:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        System.out.println("\nAnalysis:");
        for (int i = 0; i < numbers.length; i++) {
            int num = numbers[i];
            System.out.print("Element " + (i + 1) + " (" + num + "): ");
            
            if (num > 0) {
                if (num % 2 == 0) {
                    System.out.println("Positive and Even");
                } else {
                    System.out.println("Positive and Odd");
                }
            } else if (num < 0) {
                System.out.println("Negative");
            } else {
                System.out.println("Zero");
            }
        }

        System.out.println("\nComparison of first and last elements:");
        int first = numbers[0];
        int last = numbers[4];

        if (first == last) {
            System.out.println("First and Last elements are Equal");
        } else if (first > last) {
            System.out.println("First element is Greater than Last");
        } else {
            System.out.println("First element is Less than Last");
        }

        scanner.close();
    }
}









    
            
     