class Vehicle {
    // Static variable for registration fee (common for all vehicles)
    static double registrationFee = 5000.0;

    // Final variable for unique registration number
    private final String registrationNumber;

    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Constructor using 'this' keyword
    public Vehicle(String registrationNumber, String ownerName, String vehicleType) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Static method to update registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
        System.out.println("Registration fee updated to ₹" + registrationFee);
    }

    // Method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Registration Number : " + registrationNumber);
        System.out.println("Owner Name          : " + ownerName);
        System.out.println("Vehicle Type        : " + vehicleType);
        System.out.println("Registration Fee    : ₹" + registrationFee);
        System.out.println("--------------------------------------------");
    }

    // Main method for testing
    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("MH12AB1234", "Riya Sharma", "Car");
        Vehicle v2 = new Vehicle("DL10XY5678", "Arjun Mehta", "Bike");

        // Update registration fee
        Vehicle.updateRegistrationFee(6000.0);

        // Use instanceof before displaying details
        if (v1 instanceof Vehicle) {
            v1.displayVehicleDetails();
        }

        if (v2 instanceof Vehicle) {
            v2.displayVehicleDetails();
        }
    }
}
