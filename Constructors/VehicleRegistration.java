class Vehicle {
    // Instance variables
    private String ownerName;
    private String vehicleType;

    // Class variable (same for all vehicles)
    private static double registrationFee = 1500.0; // default fee

    // Constructor
    public Vehicle(String ownerName, String vehicleType) {
        this.ownerName = ownerName;
        this.vehicleType = vehicleType;
    }

    // Instance method to display vehicle details
    public void displayVehicleDetails() {
        System.out.println("Owner Name      : " + ownerName);
        System.out.println("Vehicle Type    : " + vehicleType);
        System.out.println("Registration Fee: ₹" + registrationFee);
        System.out.println();
    }

    // Static method to update the registration fee
    public static void updateRegistrationFee(double newFee) {
        registrationFee = newFee;
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create vehicle objects
        Vehicle v1 = new Vehicle("Alice", "Two-Wheeler");
        Vehicle v2 = new Vehicle("Bob", "Four-Wheeler");

        // Display details before fee update
        System.out.println("Before Fee Update:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();

        // Update registration fee
        Vehicle.updateRegistrationFee(2000.0);

        // Display details after fee update
        System.out.println("After Fee Update:");
        v1.displayVehicleDetails();
        v2.displayVehicleDetails();
    }
}
