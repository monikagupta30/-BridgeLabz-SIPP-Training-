import java.util.*;

class Product {
    String name;
    double price;
    double rating;
    double discount;

    public Product(String name, double price, double rating, double discount) {
        this.name = name;
        this.price = price;
        this.rating = rating;
        this.discount = discount;
    }

    @Override
    public String toString() {
        return name + " | ₹" + price + " | " + rating + " | " + discount + "% off";
    }
}

public class ECommerceSorting {
    public static void main(String[] args) {
        List<Product> products = Arrays.asList(
            new Product("Laptop", 55000, 4.5, 10),
            new Product("Smartphone", 30000, 4.7, 15),
            new Product("Headphones", 2000, 4.2, 25),
            new Product("Smartwatch", 8000, 4.0, 20)
        );

        // Sorting by Price (Low to High)
        System.out.println("\n Sort by Price:");
        products.sort((p1, p2) -> Double.compare(p1.price, p2.price));
        products.forEach(System.out::println);

        // Sorting by Rating (High to Low)
        System.out.println("\n Sort by Rating:");
        products.sort((p1, p2) -> Double.compare(p2.rating, p1.rating));
        products.forEach(System.out::println);

        // Sorting by Discount (High to Low)
        System.out.println("\n Sort by Discount:");
        products.sort((p1, p2) -> Double.compare(p2.discount, p1.discount));
        products.forEach(System.out::println);
    }
}
