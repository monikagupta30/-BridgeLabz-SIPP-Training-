import java.util.*;

// Taxable interface
interface Taxable {
    double calculateTax();
    String getTaxDetails();
}

// Abstract Product class
abstract class Product {
    private String productId;
    private String name;
    private double price;

    // Constructor
    public Product(String productId, String name, double price) {
        this.productId = productId;
        this.name = name;
        this.price = price;
    }

    // Encapsulation: Getters and Setters
    public String getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    // Abstract method
    public abstract double calculateDiscount();

    // Common method to show product info
    public void displayInfo() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + name);
        System.out.println("Price: ₹" + price);
    }
}

// Electronics class
class Electronics extends Product implements Taxable {
    public Electronics(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.10; // 10% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.18; // 18% GST
    }

    @Override
    public String getTaxDetails() {
        return "18% GST on Electronics";
    }
}

// Clothing class
class Clothing extends Product implements Taxable {
    public Clothing(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.20; // 20% discount
    }

    @Override
    public double calculateTax() {
        return getPrice() * 0.05; // 5% GST
    }

    @Override
    public String getTaxDetails() {
        return "5% GST on Clothing";
    }
}

// Groceries class (non-taxable)
class Groceries extends Product {
    public Groceries(String productId, String name, double price) {
        super(productId, name, price);
    }

    @Override
    public double calculateDiscount() {
        return getPrice() * 0.05; // 5% discount
    }

    // No tax since not implementing Taxable
}

public class ECommercePlatform {
    // Polymorphic method to calculate final price
    public static void printFinalBill(Product product) {
        product.displayInfo();
        double discount = product.calculateDiscount();
        double tax = 0;

        if (product instanceof Taxable) {
            tax = ((Taxable) product).calculateTax();
            System.out.println("Tax: ₹" + tax);
            System.out.println("Tax Info: " + ((Taxable) product).getTaxDetails());
        } else {
            System.out.println("Tax: ₹0.0 (Non-taxable item)");
        }

        System.out.println("Discount: ₹" + discount);
        double finalPrice = product.getPrice() + tax - discount;
        System.out.println("Final Price: ₹" + finalPrice);
        System.out.println("-----------------------------------");
    }

    public static void main(String[] args) {
        List<Product> cart = new ArrayList<>();

        cart.add(new Electronics("E101", "Smartphone", 20000));
        cart.add(new Clothing("C202", "Jeans", 1500));
        cart.add(new Groceries("G303", "Wheat Flour", 600));

        // Polymorphic behavior
        for (Product p : cart) {
            printFinalBill(p);
        }
    }
}
