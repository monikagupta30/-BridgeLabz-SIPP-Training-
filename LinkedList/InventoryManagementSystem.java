import java.util.Scanner;

class ItemNode {
    String name;
    int id;
    int quantity;
    double price;
    ItemNode next;

    public ItemNode(String name, int id, int quantity, double price) {
        this.name = name;
        this.id = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}

class Inventory {
    ItemNode head = null;

    // Add item at beginning
    void addAtBeginning(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        newNode.next = head;
        head = newNode;
        System.out.println("Item added at beginning.");
    }

    // Add item at end
    void addAtEnd(String name, int id, int quantity, double price) {
        ItemNode newNode = new ItemNode(name, id, quantity, price);
        if (head == null) {
            head = newNode;
        } else {
            ItemNode temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newNode;
        }
        System.out.println("Item added at end.");
    }

    // Add item at specific position (1-based)
    void addAtPosition(int pos, String name, int id, int quantity, double price) {
        if (pos <= 1 || head == null) {
            addAtBeginning(name, id, quantity, price);
            return;
        }

        ItemNode newNode = new ItemNode(name, id, quantity, price);
        ItemNode temp = head;
        int count = 1;

        while (count < pos - 1 && temp.next != null) {
            temp = temp.next;
            count++;
        }

        newNode.next = temp.next;
        temp.next = newNode;
        System.out.println("Item added at position " + pos);
    }

    // Remove item by ID
    void removeById(int id) {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }

        if (head.id == id) {
            head = head.next;
            System.out.println("Item removed.");
            return;
        }

        ItemNode temp = head, prev = null;

        while (temp != null && temp.id != id) {
            prev = temp;
            temp = temp.next;
        }

        if (temp == null) {
            System.out.println("Item not found.");
        } else {
            prev.next = temp.next;
            System.out.println("Item removed.");
        }
    }

    // Update quantity by ID
    void updateQuantity(int id, int newQty) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                temp.quantity = newQty;
                System.out.println("Quantity updated.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by ID
    void searchById(int id) {
        ItemNode temp = head;
        while (temp != null) {
            if (temp.id == id) {
                displayItem(temp);
                return;
            }
            temp = temp.next;
        }
        System.out.println("Item not found.");
    }

    // Search by Name
    void searchByName(String name) {
        ItemNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.name.equalsIgnoreCase(name)) {
                displayItem(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No item found with name: " + name);
    }

    // Display a single item
    void displayItem(ItemNode item) {
        System.out.println("ID: " + item.id + ", Name: " + item.name +
                ", Quantity: " + item.quantity + ", Price: " + item.price);
    }

    // Display all items
    void displayAll() {
        if (head == null) {
            System.out.println("Inventory is empty.");
            return;
        }
        ItemNode temp = head;
        System.out.println("--- Inventory Items ---");
        while (temp != null) {
            displayItem(temp);
            temp = temp.next;
        }
    }

    // Calculate total value
    void calculateTotalValue() {
        double total = 0;
        ItemNode temp = head;
        while (temp != null) {
            total += temp.quantity * temp.price;
            temp = temp.next;
        }
        System.out.println("Total Inventory Value: ₹" + total);
    }

    // Merge Sort Wrapper
    void sort(String criteria, boolean ascending) {
        head = mergeSort(head, criteria, ascending);
        System.out.println("Inventory sorted by " + criteria + " (" + (ascending ? "ASC" : "DESC") + ")");
    }

    // Merge Sort for Linked List
    ItemNode mergeSort(ItemNode head, String criteria, boolean ascending) {
        if (head == null || head.next == null) return head;

        ItemNode middle = getMiddle(head);
        ItemNode nextToMiddle = middle.next;
        middle.next = null;

        ItemNode left = mergeSort(head, criteria, ascending);
        ItemNode right = mergeSort(nextToMiddle, criteria, ascending);

        return merge(left, right, criteria, ascending);
    }

    // Merge two sorted lists
    ItemNode merge(ItemNode a, ItemNode b, String criteria, boolean ascending) {
        if (a == null) return b;
        if (b == null) return a;

        boolean condition;
        if (criteria.equalsIgnoreCase("name")) {
            condition = ascending ?
                    a.name.compareToIgnoreCase(b.name) <= 0 :
                    a.name.compareToIgnoreCase(b.name) > 0;
        } else {
            condition = ascending ?
                    a.price <= b.price :
                    a.price > b.price;
        }

        if (condition) {
            a.next = merge(a.next, b, criteria, ascending);
            return a;
        } else {
            b.next = merge(a, b.next, criteria, ascending);
            return b;
        }
    }

    // Get middle node for merge sort
    ItemNode getMiddle(ItemNode head) {
        if (head == null) return head;
        ItemNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- Inventory Menu ---");
            System.out.println("1. Add Item at Beginning");
            System.out.println("2. Add Item at End");
            System.out.println("3. Add Item at Position");
            System.out.println("4. Remove Item by ID");
            System.out.println("5. Update Quantity by ID");
            System.out.println("6. Search by ID");
            System.out.println("7. Search by Name");
            System.out.println("8. Display All Items");
            System.out.println("9. Calculate Total Inventory Value");
            System.out.println("10. Sort by Name");
            System.out.println("11. Sort by Price");
            System.out.println("12. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id, qty, pos;
            String name;
            double price;

            switch (choice) {
                case 1:
                    System.out.print("Name: "); name = sc.nextLine();
                    System.out.print("ID: "); id = sc.nextInt();
                    System.out.print("Quantity: "); qty = sc.nextInt();
                    System.out.print("Price: "); price = sc.nextDouble();
                    inventory.addAtBeginning(name, id, qty, price);
                    break;
                case 2:
                    System.out.print("Name: "); name = sc.nextLine();
                    System.out.print("ID: "); id = sc.nextInt();
                    System.out.print("Quantity: "); qty = sc.nextInt();
                    System.out.print("Price: "); price = sc.nextDouble();
                    inventory.addAtEnd(name, id, qty, price);
                    break;
                case 3:
                    System.out.print("Position: "); pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Name: "); name = sc.nextLine();
                    System.out.print("ID: "); id = sc.nextInt();
                    System.out.print("Quantity: "); qty = sc.nextInt();
                    System.out.print("Price: "); price = sc.nextDouble();
                    inventory.addAtPosition(pos, name, id, qty, price);
                    break;
                case 4:
                    System.out.print("Enter Item ID to remove: "); id = sc.nextInt();
                    inventory.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Item ID: "); id = sc.nextInt();
                    System.out.print("Enter New Quantity: "); qty = sc.nextInt();
                    inventory.updateQuantity(id, qty);
                    break;
                case 6:
                    System.out.print("Enter Item ID to search: "); id = sc.nextInt();
                    inventory.searchById(id);
                    break;
                case 7:
                    System.out.print("Enter Item Name to search: "); name = sc.nextLine();
                    inventory.searchByName(name);
                    break;
                case 8:
                    inventory.displayAll();
                    break;
                case 9:
                    inventory.calculateTotalValue();
                    break;
                case 10:
                    System.out.print("Sort by Name (asc/desc): ");
                    String orderN = sc.nextLine();
                    inventory.sort("name", orderN.equalsIgnoreCase("asc"));
                    break;
                case 11:
                    System.out.print("Sort by Price (asc/desc): ");
                    String orderP = sc.nextLine();
                    inventory.sort("price", orderP.equalsIgnoreCase("asc"));
                    break;
                case 12:
                    System.out.println("Exiting Inventory System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 12);

        sc.close();
    }
}
