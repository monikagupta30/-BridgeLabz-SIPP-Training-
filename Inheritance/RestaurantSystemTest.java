// Superclass
class Person {
    protected String name;
    protected int id;

    public Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
    }
}

// Interface
interface Worker {
    void performDuties();  // Abstract method to be implemented
}

// Subclass 1 - Chef
class Chef extends Person implements Worker {

    public Chef(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Chef");
        displayInfo();
        System.out.println("Duties: Prepares and cooks meals.\n");
    }
}

// Subclass 2 - Waiter
class Waiter extends Person implements Worker {

    public Waiter(String name, int id) {
        super(name, id);
    }

    @Override
    public void performDuties() {
        System.out.println("Role: Waiter");
        displayInfo();
        System.out.println("Duties: Serves food and handles customer requests.\n");
    }
}

// Main class to test the system
public class RestaurantSystemTest {
    public static void main(String[] args) {
        Chef chef = new Chef("Raj", 101);
        Waiter waiter = new Waiter("Anita", 102);

        chef.performDuties();
        waiter.performDuties();
    }
}
