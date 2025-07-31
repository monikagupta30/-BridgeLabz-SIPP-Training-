import java.util.ArrayList;
import java.util.Scanner;

class CartItem {
    // Attributes
    String itemName;
    double price;
    int quantity;

    // Constructor
    CartItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Method to calculate item total cost
    double getTotalCost() {
        return price * quantity;
    }

    // Display item details
    void displayItem() {
        System.out.println(itemName + " - ₹" + price + " x " + quantity + " = ₹" + getTotalCost());
    }
}

class ShoppingCart {
    static ArrayList<CartItem> cart = new ArrayList<>();

    // Method to add an item to the cart
    static void addItem(String name, double price, int quantity) {
        CartItem item = new CartItem(name, price, quantity);
        cart.add(item);
        System.out.println(name + " added to the cart.");
    }

    // Method to remove an item from the cart
    static void removeItem(String name) {
        boolean removed = false;
        for (int i = 0; i < cart.size(); i++) {
            if (cart.get(i).itemName.equalsIgnoreCase(name)) {
                cart.remove(i);
                System.out.println(name + " removed from the cart.");
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("Item not found in the cart.");
        }
    }

    // Method to display total cost and all items
    static void displayCart() {
        double total = 0;
        System.out.println("\n--- Cart Items ---");
        if (cart.isEmpty()) {
            System.out.println("Cart is empty.");
        } else {
            for (CartItem item : cart) {
                item.displayItem();
                total += item.getTotalCost();
            }
            System.out.println("Total Cost: ₹" + total);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Shopping Cart Menu ---");
            System.out.println("1. Add Item");
            System.out.println("2. Remove Item");
            System.out.println("3. View Cart");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter Quantity: ");
                    int qty = scanner.nextInt();

                    addItem(name, price, qty);
                    break;

                case 2:
                    System.out.print("Enter Item Name to Remove: ");
                    String removeName = scanner.nextLine();
                    removeItem(removeName);
                    break;

                case 3:
                    displayCart();
                    break;

                case 4:
                    System.out.println("Exiting Shopping Cart. Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 4);
    }
}
