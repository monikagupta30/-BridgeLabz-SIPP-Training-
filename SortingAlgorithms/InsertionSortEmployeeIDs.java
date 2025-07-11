import java.util.Scanner;

public class InsertionSortEmployeeIDs {

    // Function to perform insertion sort on an array
    public static void insertionSort(int[] empIds) {
        int n = empIds.length;

        for (int i = 1; i < n; i++) {
            int key = empIds[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && empIds[j] > key) {
                empIds[j + 1] = empIds[j];
                j = j - 1;
            }

            // Insert the key at its correct position
            empIds[j + 1] = key;
        }
    }

    // Function to display the array
    public static void displayArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();

        int[] empIds = new int[n];
        System.out.println("Enter employee IDs:");
        for (int i = 0; i < n; i++) {
            empIds[i] = sc.nextInt();
        }

        System.out.println("Original Employee IDs:");
        displayArray(empIds);

        insertionSort(empIds);

        System.out.println("Sorted Employee IDs (Ascending Order):");
        displayArray(empIds);

        sc.close();
    }
}
