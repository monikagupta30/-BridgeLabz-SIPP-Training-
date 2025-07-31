class Product {
    // Instance variables
    private String productName;
    private double price;

    // Class variable (shared among all products)
    private static int totalProducts = 0;

    // Constructor
    public Product(String productName, double price) {
        this.productName = productName;
        this.price = price;
        totalProducts++;  // Increment total products whenever a new object is created
    }

    // Instance method to display product details
    public void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price       : ₹" + price);
        System.out.println();
    }

    // Static (class) method to display total number of products
    public static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create product objects
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Smartphone", 25000);
        Product p3 = new Product("Headphones", 1500);

        // Display product details
        System.out.println("Product Details:");
        p1.displayProductDetails();
        p2.displayProductDetails();
        p3.displayProductDetails();

        // Display total products
        Product.displayTotalProducts();
    }
}
