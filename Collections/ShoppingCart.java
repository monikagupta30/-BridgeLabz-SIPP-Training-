import java.util.*;

public class ShoppingCart {
    public static void main(String[] args) {
        // Product catalog with prices
        Map<String, Double> productPrices = new HashMap<>();
        productPrices.put("Laptop", 75000.0);
        productPrices.put("Mouse", 500.0);
        productPrices.put("Keyboard", 1500.0);
        productPrices.put("Monitor", 12000.0);
        productPrices.put("USB Cable", 300.0);

        // Shopping cart (maintain order of items added)
        Map<String, Integer> cart = new LinkedHashMap<>();
        addToCart(cart, "Mouse", 1);
        addToCart(cart, "Laptop", 1);
        addToCart(cart, "Keyboard", 2);
        addToCart(cart, "USB Cable", 3);

        // Display cart in order of insertion
        System.out.println("🛒 Cart Items (in order of addition):");
        for (Map.Entry<String, Integer> entry : cart.entrySet()) {
            String item = entry.getKey();
            int quantity = entry.getValue();
            double price = productPrices.get(item);
            System.out.printf("%s (x%d): ₹%.2f each\n", item, quantity, price);
        }

        // Group items by price using TreeMap
        Map<Double, List<String>> sortedByPrice = new TreeMap<>();
        for (String item : cart.keySet()) {
            double price = productPrices.get(item);
            sortedByPrice.computeIfAbsent(price, k -> new ArrayList<>()).add(item);
        }

        // Display items sorted by price
        System.out.println("\n Items Sorted by Price (TreeMap):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            double price = entry.getKey();
            for (String item : entry.getValue()) {
                System.out.printf("%s: ₹%.2f\n", item, price);
            }
        }
    }

    // Helper method to add item to the cart
    static void addToCart(Map<String, Integer> cart, String item, int quantity) {
        cart.put(item, cart.getOrDefault(item, 0) + quantity);
    }
}
