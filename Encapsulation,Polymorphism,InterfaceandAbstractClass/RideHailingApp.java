import java.util.*;

// Interface for GPS functionality
interface GPS {
    String getCurrentLocation();
    void updateLocation(String newLocation);
}

// Abstract class for all vehicles
abstract class Vehicle {
    private String vehicleId;
    private String driverName;
    private double ratePerKm;

    public Vehicle(String vehicleId, String driverName, double ratePerKm) {
        this.vehicleId = vehicleId;
        this.driverName = driverName;
        this.ratePerKm = ratePerKm;
    }

    public String getVehicleId() {
        return vehicleId;
    }

    public String getDriverName() {
        return driverName;
    }

    public double getRatePerKm() {
        return ratePerKm;
    }

    public void setRatePerKm(double rate) {
        this.ratePerKm = rate;
    }

    // Concrete method
    public void getVehicleDetails() {
        System.out.println("Vehicle ID: " + vehicleId);
        System.out.println("Driver Name: " + driverName);
        System.out.println("Rate per Km: ₹" + ratePerKm);
    }

    // Abstract method
    public abstract double calculateFare(double distance);
}

// Car subclass
class Car extends Vehicle implements GPS {
    private String currentLocation;

    public Car(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Garage";
    }

    @Override
    public double calculateFare(double distance) {
        return distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Bike subclass
class Bike extends Vehicle implements GPS {
    private String currentLocation;

    public Bike(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Bike Stand";
    }

    @Override
    public double calculateFare(double distance) {
        // 10% discount for bikes
        return distance * getRatePerKm() * 0.9;
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Auto subclass
class Auto extends Vehicle implements GPS {
    private String currentLocation;

    public Auto(String vehicleId, String driverName, double ratePerKm) {
        super(vehicleId, driverName, ratePerKm);
        this.currentLocation = "Auto Stand";
    }

    @Override
    public double calculateFare(double distance) {
        double baseFare = 30; // Flat base fare
        return baseFare + distance * getRatePerKm();
    }

    @Override
    public String getCurrentLocation() {
        return currentLocation;
    }

    @Override
    public void updateLocation(String newLocation) {
        currentLocation = newLocation;
    }
}

// Main class
public class RideHailingApp {
    public static void processRide(Vehicle vehicle, double distance) {
        System.out.println("\n------------------------------");
        vehicle.getVehicleDetails();
        System.out.println("Distance: " + distance + " km");
        double fare = vehicle.calculateFare(distance);
        System.out.println("Calculated Fare: ₹" + fare);

        if (vehicle instanceof GPS gps) {
            System.out.println("Current Location: " + gps.getCurrentLocation());
            gps.updateLocation("Drop-off Point");
            System.out.println("Updated Location: " + gps.getCurrentLocation());
        }
    }

    public static void main(String[] args) {
        List<Vehicle> rides = new ArrayList<>();
        rides.add(new Car("C101", "Rajeev", 15.0));
        rides.add(new Bike("B202", "Sneha", 10.0));
        rides.add(new Auto("A303", "Kumar", 8.0));

        double[] distances = {12.5, 8.0, 5.0};

        for (int i = 0; i < rides.size(); i++) {
            processRide(rides.get(i), distances[i]);
        }
    }
}
