import java.util.Scanner;

class Circle {
    // Attribute
    double radius;

    // Constructor
    Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to calculate circumference
    double calculateCircumference() {
        return 2 * Math.PI * radius;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Circle Details:");
        System.out.println("Radius         : " + radius);
        System.out.println("Area           : " + calculateArea());
        System.out.println("Circumference  : " + calculateCircumference());
    }
}

class CircleCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking radius as input
        System.out.print("Enter the radius of the circle: ");
        double radius = scanner.nextDouble();

        // Creating Circle object
        Circle circle = new Circle(radius);

        // Displaying circle details
        circle.displayDetails();
    }
}
