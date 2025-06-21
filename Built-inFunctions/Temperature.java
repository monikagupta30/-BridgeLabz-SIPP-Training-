import java.util.Scanner;

class TemperatureConverter {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("1. Fahrenheit to Celsius");
        System.out.println("2. Celsius to Fahrenheit");
        System.out.print("Choose an option (1 or 2): ");
        int choice = scanner.nextInt();

        double temperature, converted;

        switch (choice) {
            case 1:
                System.out.print("Enter temperature in Fahrenheit: ");
                temperature = scanner.nextDouble();
                converted = fahrenheitToCelsius(temperature);
                System.out.printf("Temperature in Celsius: %.2f°C\n", converted);
                break;

            case 2:
                System.out.print("Enter temperature in Celsius: ");
                temperature = scanner.nextDouble();
                converted = celsiusToFahrenheit(temperature);
                System.out.printf("Temperature in Fahrenheit: %.2f°F\n", converted);
                break;

            default:
                System.out.println("Invalid option. Please choose 1 or 2.");
        }

        scanner.close();
    }

    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5 / 9;
    }

    public static double celsiusToFahrenheit(double c) {
        return (c * 9 / 5) + 32;
    }
}
