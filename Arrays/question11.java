import java.util.Scanner;
class BMICalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter number of persons: ");
        int n = scanner.nextInt();

        double[] weight = new double[n];
        double[] height = new double[n];
        double[] bmi = new double[n];
        String[] status = new String[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter data for person " + (i + 1) + ":");
            System.out.print("Height in meters: ");
            height[i] = scanner.nextDouble();
            System.out.print("Weight in kg: ");
            weight[i] = scanner.nextDouble();

            bmi[i] = weight[i] / (height[i] * height[i]);

            if (bmi[i] < 18.5) {
                status[i] = "Underweight";
            } else if (bmi[i] < 25) {
                status[i] = "Normal weight";
            } else if (bmi[i] < 30) {
                status[i] = "Overweight";
            } else {
                status[i] = "Obese";
            }
        }

        System.out.println("\n----- BMI Report -----");
        for (int i = 0; i < n; i++) {
            System.out.printf("Person %d - Height: %.2f m, Weight: %.2f kg, BMI: %.2f, Status: %s%n",
                    i + 1, height[i], weight[i], bmi[i], status[i]);
        }

        scanner.close();
    }
}
