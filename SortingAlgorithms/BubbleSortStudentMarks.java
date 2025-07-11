import java.util.Scanner;

public class BubbleSortStudentMarks {
    
    // Function to perform bubble sort on an array
    public static void bubbleSort(int[] marks) {
        int n = marks.length;
        boolean swapped;

        // Outer loop for passes
        for (int i = 0; i < n - 1; i++) {
            swapped = false;

            // Inner loop for comparing adjacent elements
            for (int j = 0; j < n - i - 1; j++) {
                if (marks[j] > marks[j + 1]) {
                    // swap if elements are in wrong order
                    int temp = marks[j];
                    marks[j] = marks[j + 1];
                    marks[j + 1] = temp;
                    swapped = true; 
                }
            }
            if (!swapped) {
                break;
            }
        }
    }

    // Function to display the marks 
    public static void displayMarks(int[] marks) {
        for (int mark : marks) {
            System.out.print(mark + " ");
        }
        System.out.println();
    } 
   
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of students: ");
        int n = sc.nextInt();
        int[] marks = new int[n];
        System.out.println("Enter the marks of students: ");
        for(int i = 0; i < n; i++) {
            marks[i] = sc.nextInt();
        }
        System.out.println("Original Marks: ");
        displayMarks(marks);
       
        bubbleSort(marks);
        System.out.println("Sorted Marks (Ascending Order):");
        displayMarks(marks);
        sc.close();
    }
}    





















   