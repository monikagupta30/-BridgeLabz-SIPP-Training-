import java.util.Scanner;
class MeanHeight {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double[] heights = new double[11];

        double sum = 0;
        System.out.println("Enter the heights of 11 football players (in cm or meters):");
        for (int i = 0; i < 11; i++) {
            System.out.print("Enter height of player " + (i + 1) + ": ");
            heights[i] = scanner.nextDouble();
            sum += heights[i];
        }

        double mean = sum / 11;
        System.out.printf("The mean height of the football team is: %.2f\n", mean);

        scanner.close();
    }
}
