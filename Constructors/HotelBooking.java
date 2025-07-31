class HotelBooking {
    // Attributes
    private String guestName;
    private String roomType;
    private int nights;

    // Default constructor
    public HotelBooking() {
        this.guestName = "Unknown";
        this.roomType = "Standard";
        this.nights = 1;
    }

    // Parameterized constructor
    public HotelBooking(String guestName, String roomType, int nights) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.nights = nights;
    }

    // Copy constructor
    public HotelBooking(HotelBooking other) {
        this.guestName = other.guestName;
        this.roomType = other.roomType;
        this.nights = other.nights;
    }

    // Method to display booking details
    public void displayBooking() {
        System.out.println("Guest Name: " + guestName);
        System.out.println("Room Type : " + roomType);
        System.out.println("Nights     : " + nights);
        System.out.println();
    }

    // Main method to test constructors
    public static void main(String[] args) {
        // Default constructor
        HotelBooking booking1 = new HotelBooking();
        System.out.println("Default Booking:");
        booking1.displayBooking();

        // Parameterized constructor
        HotelBooking booking2 = new HotelBooking("John Doe", "Deluxe", 3);
        System.out.println("Custom Booking:");
        booking2.displayBooking();

        // Copy constructor
        HotelBooking booking3 = new HotelBooking(booking2);
        System.out.println("Copied Booking:");
        booking3.displayBooking();
    }
}
