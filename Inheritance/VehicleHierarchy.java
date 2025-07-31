//Superclass 
class Vehicle {
    int maxSpeed;
    String fuelType;

    //Constructor
    Vehicle(int maxSpeed, String fuelType) {
        this.maxSpeed = maxSpeed;
        this.fuelType = fuelType;
    }
    //Methods to display info
    void displayInfo() {
        System.out.println("Max Speed: "+ maxSpeed + "Km/h");
        System.out.println("Fuel Type: " + fuelType);
    }
}

//Subclass Car
class Car extends Vehicle {
    int seatCapacity;
    Car(int maxSpeed, String fuelType, int seatCapacity) {
        super(maxSpeed, fuelType);
        this.seatCapacity = seatCapacity;
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle name: Car");
        System.out.println("Seat Capacity: " + seatCapacity);
    }
}

//Subclass Truck
class Truck extends Vehicle {
    int loadCapacity;
    Truck(int maxSpeed,String fuelType, int LoadCapacity) {
        super(maxSpeed,fuelType);
        this.loadCapacity = loadCapacity;
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle name: Truck");
        System.out.println("Load Capacity: " + loadCapacity + "kg");
    }
}

//Subclass MotorCycle
class MotorCycle extends Vehicle {
    boolean hasCarrier;
    MotorCycle(int maxSpeed, String fuelType, boolean hasCarrier) {
        super(maxSpeed,fuelType);
        this.hasCarrier = hasCarrier;
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Vehicle name: MotorCycle");
        System.out.println("Has Carrier" + (hasCarrier ? "Yes" : "No"));
    }
}
//Main class to test
public class VehicleHierarchy {
    public static void main(String[] args) {
        Vehicle car = new Car(180, "Petrol", 5);
        Vehicle truck = new Truck(120, "Diesel", 10000);
        Vehicle motorcycle = new MotorCycle(150, "Petrol", true);

        //Polymorphism
        Vehicle[] vehicles = {car, truck, motorcycle};

        //displaying info for each vehicle
        for (Vehicle v : vehicles){
            System.out.println("\n=== Vehicle details ===");
            v.displayInfo();
        }
    }
}























