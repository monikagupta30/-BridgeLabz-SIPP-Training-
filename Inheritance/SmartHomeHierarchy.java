// Superclass
class Device {
    protected String deviceId;
    protected String status;

    // Constructor
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display status (can be overridden)
    public void displayStatus() {
        System.out.println("Device ID: " + deviceId);
        System.out.println("Status: " + status);
    }
}

// Subclass - single inheritance from Device
class Thermostat extends Device {
    private double temperatureSetting;

    // Constructor
    public Thermostat(String deviceId, String status, double temperatureSetting) {
        super(deviceId, status); // Call superclass constructor
        this.temperatureSetting = temperatureSetting;
    }

    // Override displayStatus to include temperature
    @Override
    public void displayStatus() {
        super.displayStatus(); // Call superclass method
        System.out.println("Temperature Setting: " + temperatureSetting + "°C");
    }
}

// Main class to test
public class SmartHomeHierarchy {
    public static void main(String[] args) {
        Thermostat t1 = new Thermostat("TH001", "Active", 23.5);
        t1.displayStatus();
    }
}










