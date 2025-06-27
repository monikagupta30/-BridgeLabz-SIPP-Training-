import java.util.ArrayList;

class ECommercePlatformDemo {

    // Product class (can exist independently of an order)
    static class Product {
        private String productName;
        private double price;

        public Product(String productName, double price) {
            this.productName = productName;
            this.price = price;
        }

        public String getProductName() {
            return productName;
        }

        public double getPrice() {
            return price;
        }

        public void displayProduct() {
            System.out.println("  Product: " + productName + ", Price: ₹" + price);
        }
    }

    // Order class (aggregates products)
    static class Order {
        private static int idCounter = 1000;
        private int orderId;
        private ArrayList<Product> productList;

        public Order() {
            this.orderId = idCounter++;
            this.productList = new ArrayList<>();
        }

        public int getOrderId() {
            return orderId;
        }

        public void addProduct(Product product) {
            productList.add(product);
        }

        public double calculateTotal() {
            double total = 0;
            for (Product p : productList) {
                total += p.getPrice();
            }
            return total;
        }

        public void viewOrderDetails() {
            System.out.println("Order ID: " + orderId);
            for (Product p : productList) {
                p.displayProduct();
            }
            System.out.println("  Total: ₹" + calculateTotal() + "\n");
        }
    }

    // Customer class (can place multiple orders)
    static class Customer {
        private String name;
        private ArrayList<Order> orders;

        public Customer(String name) {
            this.name = name;
            this.orders = new ArrayList<>();
        }

        public String getName() {
            return name;
        }

        // Communication: place an order
        public void placeOrder(Order order) {
            orders.add(order);
            System.out.println(name + " placed Order ID: " + order.getOrderId());
        }

        public void viewAllOrders() {
            System.out.println("\nCustomer: " + name + " - Order History:");
            for (Order o : orders) {
                o.viewOrderDetails();
            }
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create products
        Product laptop = new Product("Laptop", 55000);
        Product phone = new Product("Smartphone", 25000);
        Product headphones = new Product("Headphones", 2000);
        Product mouse = new Product("Wireless Mouse", 800);

        // Create customers
        Customer alice = new Customer("Alice");
        Customer bob = new Customer("Bob");

        // Alice places an order
        Order order1 = new Order();
        order1.addProduct(laptop);
        order1.addProduct(mouse);
        alice.placeOrder(order1);

        // Bob places an order
        Order order2 = new Order();
        order2.addProduct(phone);
        order2.addProduct(headphones);
        bob.placeOrder(order2);

        // Alice places another order
        Order order3 = new Order();
        order3.addProduct(headphones);
        alice.placeOrder(order3);

        // View all orders
        alice.viewAllOrders();
        bob.viewAllOrders();
    }
}

