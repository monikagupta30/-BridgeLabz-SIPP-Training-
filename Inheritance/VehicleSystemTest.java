// Superclass
class Vehicle {
    protected String model;
    protected int maxSpeed;

    public Vehicle(String model, int maxSpeed) {
        this.model = model;
        this.maxSpeed = maxSpeed;
    }

    public void displayInfo() {
        System.out.println("Model: " + model);
        System.out.println("Max Speed: " + maxSpeed + " km/h");
    }
}

// Interface
interface Refuelable {
    void refuel();
}

// Subclass 1: ElectricVehicle
class ElectricVehicle extends Vehicle {

    public ElectricVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    public void charge() {
        System.out.println("Charging electric vehicle...");
    }

    public void displayEVDetails() {
        System.out.println("Vehicle Type: Electric");
        displayInfo();
        charge();
        System.out.println();
    }
}

// Subclass 2: PetrolVehicle implements Refuelable
class PetrolVehicle extends Vehicle implements Refuelable {

    public PetrolVehicle(String model, int maxSpeed) {
        super(model, maxSpeed);
    }

    @Override
    public void refuel() {
        System.out.println("Refueling petrol vehicle...");
    }

    public void displayPetrolDetails() {
        System.out.println("Vehicle Type: Petrol");
        displayInfo();
        refuel();
        System.out.println();
    }
}

// Main class to test the system
public class VehicleSystemTest {
    public static void main(String[] args) {
        ElectricVehicle ev = new ElectricVehicle("Tesla Model 3", 200);
        PetrolVehicle pv = new PetrolVehicle("Honda City", 180);

        ev.displayEVDetails();
        pv.displayPetrolDetails();
    }
}
