import java.util.Scanner;

class MobilePhone {
    // Attributes
    String brand;
    String model;
    double price;

    // Constructor
    MobilePhone(String brand, String model, double price) {
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    // Method to display mobile phone details
    void displayDetails() {
        System.out.println("\nMobile Phone Details:");
        System.out.println("Brand : " + brand);
        System.out.println("Model : " + model);
        System.out.println("Price : ₹" + price);
    }
}

class MobilePhoneDetails {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input from user
        System.out.print("Enter Brand: ");
        String brand = scanner.nextLine();

        System.out.print("Enter Model: ");
        String model = scanner.nextLine();

        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();

        // Create MobilePhone object
        MobilePhone phone = new MobilePhone(brand, model, price);

        // Display phone details
        phone.displayDetails();
    }
}
