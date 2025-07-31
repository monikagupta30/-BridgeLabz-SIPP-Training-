import java.util.Scanner;

class MovieTicket {
    // Attributes
    String movieName;
    String seatNumber;
    double price;

    // Method to book a ticket
    void bookTicket(String movieName, String seatNumber, double price) {
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.price = price;
        System.out.println("\nTicket booked successfully!");
    }

    // Method to display ticket details
    void displayTicket() {
        System.out.println("\n--- Ticket Details ---");
        System.out.println("Movie Name : " + movieName);
        System.out.println("Seat Number: " + seatNumber);
        System.out.println("Price      : ₹" + price);
    }
}

class MovieTicketSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create a MovieTicket object
        MovieTicket ticket = new MovieTicket();

        // Input ticket details
        System.out.print("Enter Movie Name: ");
        String movieName = scanner.nextLine();

        System.out.print("Enter Seat Number: ");
        String seatNumber = scanner.nextLine();

        System.out.print("Enter Ticket Price: ");
        double price = scanner.nextDouble();

        // Book the ticket
        ticket.bookTicket(movieName, seatNumber, price);

        // Display ticket details
        ticket.displayTicket();
    }
}
