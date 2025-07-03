import java.util.*;

// Interface for applying discount
interface Discountable {
    double applyDiscount();
    String getDiscountDetails();
}

// Abstract base class
abstract class FoodItem {
    private String itemName;
    private double price;
    private int quantity;

    // Constructor
    public FoodItem(String itemName, double price, int quantity) {
        this.itemName = itemName;
        this.price = price;
        this.quantity = quantity;
    }

    // Encapsulated Getters
    public String getItemName() {
        return itemName;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    // Abstract method to be implemented
    public abstract double calculateTotalPrice();

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item: " + itemName);
        System.out.println("Price per item: ₹" + price);
        System.out.println("Quantity: " + quantity);
    }
}

// VegItem class
class VegItem extends FoodItem implements Discountable {
    public VegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return getPrice() * getQuantity(); // No extra charge
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.1; // 10% discount
    }

    @Override
    public String getDiscountDetails() {
        return "10% discount on Veg Items";
    }
}

// NonVegItem class
class NonVegItem extends FoodItem implements Discountable {
    private final double nonVegChargePerItem = 20.0; // Extra charge per item

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() + nonVegChargePerItem) * getQuantity();
    }

    @Override
    public double applyDiscount() {
        return calculateTotalPrice() * 0.05; // 5% discount
    }

    @Override
    public String getDiscountDetails() {
        return "5% discount on Non-Veg Items (after extra charge of ₹20 per item)";
    }
}

//Main Class for Processing Orders (Polymorphism)
public class FoodDeliverySystem {
    // Polymorphic method to process any food item
    public static void processOrder(FoodItem item) {
        System.out.println("----------------------------");
        item.getItemDetails();

        double totalPrice = item.calculateTotalPrice();
        System.out.println("Total Price before discount: ₹" + totalPrice);

        if (item instanceof Discountable) {
            Discountable d = (Discountable) item;
            double discount = d.applyDiscount();
            System.out.println("Discount Applied: ₹" + discount);
            System.out.println(d.getDiscountDetails());
            System.out.println("Final Price after discount: ₹" + (totalPrice - discount));
        }
        System.out.println("----------------------------\n");
    }

    public static void main(String[] args) {
        // Create a mixed order
        List<FoodItem> orderList = new ArrayList<>();

        orderList.add(new VegItem("Paneer Butter Masala", 200, 2));
        orderList.add(new NonVegItem("Chicken Biryani", 250, 1));
        orderList.add(new VegItem("Veg Burger", 80, 3));
        orderList.add(new NonVegItem("Fish Curry", 300, 2));

        for (FoodItem item : orderList) {
            processOrder(item); // Polymorphism in action
        }
    }
}

