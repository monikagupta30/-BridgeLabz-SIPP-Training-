import java.util.Scanner;

public class CountingSortStudentAges {

    // Counting Sort Function for ages between 10 to 18
    public static void countingSort(int[] ages) {
        int minAge = 10;
        int maxAge = 18;
        int range = maxAge - minAge + 1;

        int[] count = new int[range];      // To store frequency of each age
        int[] output = new int[ages.length]; // Output array

        // Step 1: Count occurrences
        for (int age : ages) {
            count[age - minAge]++;
        }

        // Step 2: Compute cumulative count
        for (int i = 1; i < range; i++) {
            count[i] += count[i - 1];
        }

        // Step 3: Place elements in correct position (stable sort)
        for (int i = ages.length - 1; i >= 0; i--) {
            int age = ages[i];
            output[count[age - minAge] - 1] = age;
            count[age - minAge]--;
        }

        // Copy sorted output to original array
        for (int i = 0; i < ages.length; i++) {
            ages[i] = output[i];
        }
    }

    // Display the array
    public static void display(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    // Main method
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = sc.nextInt();

        int[] ages = new int[n];
        System.out.println("Enter ages (10 to 18):");
        for (int i = 0; i < n; i++) {
            int age = sc.nextInt();
            if (age < 10 || age > 18) {
                System.out.println("Invalid age entered. Please enter age between 10 and 18.");
                i--; // repeat this iteration
            } else {
                ages[i] = age;
            }
        }

        System.out.println("Original Ages:");
        display(ages);

        countingSort(ages);

        System.out.println("Sorted Ages:");
        display(ages);
    }
}
