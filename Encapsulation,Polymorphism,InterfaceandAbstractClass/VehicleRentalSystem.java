import java.util.*;

// Interface for insurance
interface Insurable {
    double calculateInsurance();
    String getInsuranceDetails();
}

// Abstract base class
abstract class Vehicle {
    private String vehicleNumber;
    private String type;
    private double rentalRate;

    public Vehicle(String vehicleNumber, String type, double rentalRate) {
        this.vehicleNumber = vehicleNumber;
        this.type = type;
        this.rentalRate = rentalRate;
    }

    // Encapsulation with getters
    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public String getType() {
        return type;
    }

    public double getRentalRate() {
        return rentalRate;
    }

    // Abstract method
    public abstract double calculateRentalCost(int days);

    public void displayInfo() {
        System.out.println("Vehicle No: " + vehicleNumber);
        System.out.println("Type: " + type);
        System.out.println("Rental Rate (per day): ₹" + rentalRate);
    }
}

// Car subclass
class Car extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Car(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Car", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 500; // flat service fee
    }

    @Override
    public double calculateInsurance() {
        return 0.05 * getRentalRate(); // 5% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Car Insurance Policy: " + maskPolicyNumber();
    }

    // Encapsulation - mask policy number
    private String maskPolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Bike subclass
class Bike extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Bike(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Bike", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days;
    }

    @Override
    public double calculateInsurance() {
        return 0.02 * getRentalRate(); // 2% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Bike Insurance Policy: " + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Truck subclass
class Truck extends Vehicle implements Insurable {
    private String insurancePolicyNumber;

    public Truck(String vehicleNumber, double rentalRate, String insurancePolicyNumber) {
        super(vehicleNumber, "Truck", rentalRate);
        this.insurancePolicyNumber = insurancePolicyNumber;
    }

    @Override
    public double calculateRentalCost(int days) {
        return getRentalRate() * days + 1000; // higher service charge
    }

    @Override
    public double calculateInsurance() {
        return 0.1 * getRentalRate(); // 10% of daily rate
    }

    @Override
    public String getInsuranceDetails() {
        return "Truck Insurance Policy: " + maskPolicyNumber();
    }

    private String maskPolicyNumber() {
        return "****" + insurancePolicyNumber.substring(insurancePolicyNumber.length() - 4);
    }
}

// Main class
public class VehicleRentalSystem {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car("CAR1234", 1500, "POLCAR001122"));
        vehicles.add(new Bike("BIK5678", 500, "POLBIK009988"));
        vehicles.add(new Truck("TRK9012", 3000, "POLTRK778899"));

        int rentalDays = 5;

        for (Vehicle v : vehicles) {
            System.out.println("================================");
            v.displayInfo();
            System.out.println("Rental Cost for " + rentalDays + " days: ₹" + v.calculateRentalCost(rentalDays));

            if (v instanceof Insurable) {
                Insurable ins = (Insurable) v;
                System.out.println("Insurance: ₹" + ins.calculateInsurance());
                System.out.println(ins.getInsuranceDetails());
            }

            System.out.println("================================\n");
        }
    }
}
