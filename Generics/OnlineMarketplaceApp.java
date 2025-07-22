import java.util.*;

// === Category Classes ===
class BookCategory {
    private String genre;

    public BookCategory(String genre) {
        this.genre = genre;
    }

    public String getGenre() {
        return genre;
    }

    @Override
    public String toString() {
        return "Book - " + genre;
    }
}

class ClothingCategory {
    private String type;

    public ClothingCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Clothing - " + type;
    }
}

class GadgetCategory {
    private String deviceType;

    public GadgetCategory(String deviceType) {
        this.deviceType = deviceType;
    }

    public String getDeviceType() {
        return deviceType;
    }

    @Override
    public String toString() {
        return "Gadget - " + deviceType;
    }
}

// === Generic Product Class ===
class Product<T> {
    private String name;
    private double price;
    private T category;

    public Product(String name, double price, T category) {
        this.name = name;
        this.price = price;
        this.category = category;
    }

    public T getCategory() {
        return category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double newPrice) {
        this.price = newPrice;
    }

    public String getName() {
        return name;
    }

    public void display() {
        System.out.printf("%s [%s] - ₹%.2f\n", name, category.toString(), price);
    }
}

// === Utility Class for Marketplace ===
class MarketplaceUtils {

    // Generic method with bounded type parameter
    public static <T extends Product<?>> void applyDiscount(T product, double percentage) {
        double oldPrice = product.getPrice();
        double discountAmount = oldPrice * (percentage / 100.0);
        product.setPrice(oldPrice - discountAmount);
        System.out.printf("Applied %.1f%% discount to '%s'. New Price: ₹%.2f\n",
                percentage, product.getName(), product.getPrice());
    }
}

// === Main Application ===
public class OnlineMarketplaceApp {
    public static void main(String[] args) {
        // Book Products
        Product<BookCategory> book1 = new Product<>("Java Programming", 499.0, new BookCategory("Programming"));
        Product<BookCategory> book2 = new Product<>("Harry Potter", 799.0, new BookCategory("Fiction"));

        // Clothing Products
        Product<ClothingCategory> shirt = new Product<>("Casual Shirt", 999.0, new ClothingCategory("Men's Wear"));
        Product<ClothingCategory> dress = new Product<>("Evening Dress", 1499.0, new ClothingCategory("Women's Wear"));

        // Gadget Products
        Product<GadgetCategory> phone = new Product<>("Smartphone", 15999.0, new GadgetCategory("Mobile"));
        Product<GadgetCategory> headphones = new Product<>("Bluetooth Headphones", 2999.0, new GadgetCategory("Audio"));

        // Create Catalog
        List<Product<?>> catalog = new ArrayList<>();
        catalog.add(book1);
        catalog.add(book2);
        catalog.add(shirt);
        catalog.add(dress);
        catalog.add(phone);
        catalog.add(headphones);

        // Display all products
        System.out.println("=== Product Catalog ===");
        for (Product<?> product : catalog) {
            product.display();
        }

        // Apply some discounts
        System.out.println("\n=== Applying Discounts ===");
        MarketplaceUtils.applyDiscount(book1, 10);       // 10% off on Java book
        MarketplaceUtils.applyDiscount(shirt, 15);        // 15% off on shirt
        MarketplaceUtils.applyDiscount(phone, 5);         // 5% off on phone

        // Display updated catalog
        System.out.println("\n=== Updated Product Catalog ===");
        for (Product<?> product : catalog) {
            product.display();
        }
    }
}
