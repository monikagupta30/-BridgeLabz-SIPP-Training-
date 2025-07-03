import java.time.LocalDate;

// Base class
class Order {
    protected String orderId;
    protected LocalDate orderDate;

    public Order(String orderId, LocalDate orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String getOrderStatus() {
        return "Order placed on " + orderDate;
    }
}

// Subclass: ShippedOrder inherits from Order
class ShippedOrder extends Order {
    protected String trackingNumber;

    public ShippedOrder(String orderId, LocalDate orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    @Override
    public String getOrderStatus() {
        return "Order shipped with Tracking Number: " + trackingNumber;
    }
}

// Subclass: DeliveredOrder inherits from ShippedOrder
class DeliveredOrder extends ShippedOrder {
    private LocalDate deliveryDate;

    public DeliveredOrder(String orderId, LocalDate orderDate, String trackingNumber, LocalDate deliveryDate) {
        super(orderId, orderDate, trackingNumber);
        this.deliveryDate = deliveryDate;
    }

    @Override
    public String getOrderStatus() {
        return "Order delivered on " + deliveryDate;
    }
}

// Main class to test the hierarchy
class OrderManagementTest {
    public static void main(String[] args) {
        Order order = new Order("ORD001", LocalDate.of(2025, 6, 28));
        ShippedOrder shipped = new ShippedOrder("ORD002", LocalDate.of(2025, 6, 25), "TRK12345");
        DeliveredOrder delivered = new DeliveredOrder("ORD003", LocalDate.of(2025, 6, 20), "TRK67890", LocalDate.of(2025, 6, 26));

        System.out.println(order.getOrderStatus());        // Output from Order class
        System.out.println(shipped.getOrderStatus());      // Output from ShippedOrder class
        System.out.println(delivered.getOrderStatus());    // Output from DeliveredOrder class
    }
}

