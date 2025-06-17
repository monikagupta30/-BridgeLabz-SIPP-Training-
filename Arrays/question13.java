import java.util.Scanner;
class StudentMarksCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of students: ");
        int n = scanner.nextInt();

        int[][] marks = new int[n][3]; // [][0]=Physics, [][1]=Chemistry, [][2]=Maths
        double[] percentage = new double[n];
        char[] grade = new char[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter marks for Student " + (i + 1) + ":");

            for (int j = 0; j < 3; j++) {
                String subject = (j == 0) ? "Physics" : (j == 1) ? "Chemistry" : "Maths";
                int mark;
                do {
                    System.out.print(subject + " marks (0-100): ");
                    mark = scanner.nextInt();
                    if (mark < 0 || mark > 100) {
                        System.out.println("Invalid input. Enter a mark between 0 and 100.");
                    }
                } while (mark < 0 || mark > 100);

                marks[i][j] = mark;
            }

            int total = marks[i][0] + marks[i][1] + marks[i][2];
            percentage[i] = total / 3.0;

            if (percentage[i] >= 90) {
                grade[i] = 'A';
            } else if (percentage[i] >= 80) {
                grade[i] = 'B';
            } else if (percentage[i] >= 70) {
                grade[i] = 'C';
            } else if (percentage[i] >= 60) {
                grade[i] = 'D';
            } else {
                grade[i] = 'F';
            }
        }

        System.out.println("\n---- Student Report ----");
        for (int i = 0; i < n; i++) {
            System.out.printf("Student %d - Physics: %d, Chemistry: %d, Maths: %d, Percentage: %.2f%%, Grade: %c%n",
                    i + 1,
                    marks[i][0],
                    marks[i][1],
                    marks[i][2],
                    percentage[i],
                    grade[i]);
        }

        scanner.close();
    }
}
