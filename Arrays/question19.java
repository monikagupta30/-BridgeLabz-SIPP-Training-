import java.util.Scanner;
class ZaraBonusCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final int EMPLOYEE_COUNT = 10;

        double[] salary = new double[EMPLOYEE_COUNT];
        int[] serviceYears = new int[EMPLOYEE_COUNT];
        double[] bonus = new double[EMPLOYEE_COUNT];
        double[] newSalary = new double[EMPLOYEE_COUNT];

        double totalBonus = 0;
        double totalOldSalary = 0;
        double totalNewSalary = 0;

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1) + ":");

            System.out.print("Enter salary: ");
            salary[i] = scanner.nextDouble();
            if (salary[i] <= 0) {
                System.out.println("Invalid salary! Please enter a positive number.");
                i--; // retry input for same employee
                continue;
            }

            System.out.print("Enter years of service: ");
            serviceYears[i] = scanner.nextInt();
            if (serviceYears[i] < 0) {
                System.out.println("Invalid years of service! Please enter a non-negative number.");
                i--; // retry input
                continue;
            }
        }

        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            if (serviceYears[i] > 5) {
                bonus[i] = salary[i] * 0.05;
            } else {
                bonus[i] = salary[i] * 0.02;
            }

            newSalary[i] = salary[i] + bonus[i];

            totalBonus += bonus[i];
            totalOldSalary += salary[i];
            totalNewSalary += newSalary[i];
        }

        System.out.println("\n----- Employee Bonus Summary -----");
        for (int i = 0; i < EMPLOYEE_COUNT; i++) {
            System.out.printf("Employee %d:\n", i + 1);
            System.out.printf("  Old Salary: %.2f\n", salary[i]);
            System.out.printf("  Years of Service: %d\n", serviceYears[i]);
            System.out.printf("  Bonus: %.2f\n", bonus[i]);
            System.out.printf("  New Salary: %.2f\n", newSalary[i]);
        }

        System.out.println("\n----- Company Summary -----");
        System.out.printf("Total Bonus Payout: %.2f\n", totalBonus);
        System.out.printf("Total Old Salary: %.2f\n", totalOldSalary);
        System.out.printf("Total New Salary: %.2f\n", totalNewSalary);

        scanner.close();
    }
}
