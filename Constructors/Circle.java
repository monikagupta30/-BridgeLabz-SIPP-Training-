class Circle {
    // Attribute
    private double radius;

    // Default constructor (calls parameterized constructor with default value)
    public Circle() {
        this(1.0); // Default radius is 1.0
    }

    // Parameterized constructor
    public Circle(double radius) {
        this.radius = radius;
    }

    // Method to calculate area
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // Method to display radius and area
    public void displayDetails() {
        System.out.println("Radius: " + radius);
        System.out.println("Area  : " + calculateArea());
    }

    // Main method to test the Circle class
    public static void main(String[] args) {
        // Using default constructor
        Circle defaultCircle = new Circle();
        System.out.println("Default Circle:");
        defaultCircle.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Circle customCircle = new Circle(5.5);
        System.out.println("Custom Circle:");
        customCircle.displayDetails();
    }
}
