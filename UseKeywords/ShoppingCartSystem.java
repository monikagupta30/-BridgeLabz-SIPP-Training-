class Product {
    // Static variable for discount percentage
    static double discount = 10.0; // Default discount in percent

    // Final variable - cannot be modified after assignment
    private final int productID;

    // Instance variables
    private String productName;
    private double price;
    private int quantity;

    // Constructor using 'this' keyword
    public Product(int productID, String productName, double price, int quantity) {
        this.productID = productID;
        this.productName = productName;
        this.price = price;
        this.quantity = quantity;
    }

    // Static method to update discount
    public static void updateDiscount(double newDiscount) {
        discount = newDiscount;
        System.out.println("Discount updated to: " + discount + "%");
    }

    // Method to calculate final price after discount
    public double getFinalPrice() {
        double total = price * quantity;
        return total - (total * discount / 100);
    }

    // Method to display product details
    public void displayProductDetails() {
        System.out.println("Product ID    : " + productID);
        System.out.println("Product Name  : " + productName);
        System.out.println("Unit Price    : ₹" + price);
        System.out.println("Quantity      : " + quantity);
        System.out.println("Discount      : " + discount + "%");
        System.out.println("Total Price   : ₹" + getFinalPrice());
        System.out.println("---------------------------------------");
    }

    // Main method to test
    public static void main(String[] args) {
        Product prod1 = new Product(1, "Laptop", 55000.0, 1);
        Product prod2 = new Product(2, "Mouse", 700.0, 2);

        // Update discount using static method
        Product.updateDiscount(15.0);

        // Check and display details only if object is instance of Product
        if (prod1 instanceof Product) {
            prod1.displayProductDetails();
        }

        if (prod2 instanceof Product) {
            prod2.displayProductDetails();
        }
    }
}
