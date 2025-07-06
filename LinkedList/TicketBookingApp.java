import java.util.*;

class Ticket {
    int ticketId;
    String customerName;
    String movieName;
    String seatNumber;
    String bookingTime;
    Ticket next;

    public Ticket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        this.ticketId = ticketId;
        this.customerName = customerName;
        this.movieName = movieName;
        this.seatNumber = seatNumber;
        this.bookingTime = bookingTime;
        this.next = null;
    }
}

class TicketReservationSystem {
    private Ticket head = null;
    private Ticket tail = null;

    // Add new ticket at end
    public void addTicket(int ticketId, String customerName, String movieName, String seatNumber, String bookingTime) {
        Ticket newTicket = new Ticket(ticketId, customerName, movieName, seatNumber, bookingTime);
        if (head == null) {
            head = tail = newTicket;
            newTicket.next = head;
        } else {
            tail.next = newTicket;
            newTicket.next = head;
            tail = newTicket;
        }
        System.out.println("Ticket booked successfully for " + customerName);
    }

    // Remove a ticket by ID
    public void removeTicket(int ticketId) {
        if (head == null) {
            System.out.println("No tickets to remove.");
            return;
        }

        Ticket current = head;
        Ticket previous = tail;
        boolean found = false;

        do {
            if (current.ticketId == ticketId) {
                found = true;
                if (current == head && current == tail) {
                    head = tail = null;
                } else {
                    previous.next = current.next;
                    if (current == head) head = head.next;
                    if (current == tail) tail = previous;
                }
                System.out.println("Ticket ID " + ticketId + " removed successfully.");
                return;
            }
            previous = current;
            current = current.next;
        } while (current != head);

        if (!found) System.out.println("Ticket ID not found.");
    }

    // Display all current tickets
    public void displayTickets() {
        if (head == null) {
            System.out.println("No tickets booked yet.");
            return;
        }

        System.out.println("\n--- Booked Tickets ---");
        Ticket current = head;
        do {
            System.out.println("Ticket ID: " + current.ticketId +
                    ", Customer: " + current.customerName +
                    ", Movie: " + current.movieName +
                    ", Seat: " + current.seatNumber +
                    ", Time: " + current.bookingTime);
            current = current.next;
        } while (current != head);
    }

    // Search by customer or movie
    public void searchTicket(String keyword) {
        if (head == null) {
            System.out.println("No tickets to search.");
            return;
        }

        boolean found = false;
        Ticket current = head;
        do {
            if (current.customerName.equalsIgnoreCase(keyword) || current.movieName.equalsIgnoreCase(keyword)) {
                System.out.println("Ticket Found -> ID: " + current.ticketId +
                        ", Customer: " + current.customerName +
                        ", Movie: " + current.movieName +
                        ", Seat: " + current.seatNumber +
                        ", Time: " + current.bookingTime);
                found = true;
            }
            current = current.next;
        } while (current != head);

        if (!found) System.out.println("No matching ticket found.");
    }

    // Count total tickets
    public int totalTickets() {
        if (head == null) return 0;

        int count = 0;
        Ticket current = head;
        do {
            count++;
            current = current.next;
        } while (current != head);
        return count;
    }
}

// Main class
public class TicketBookingApp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TicketReservationSystem system = new TicketReservationSystem();

        int choice;
        do {
            System.out.println("\n--- Ticket Reservation System ---");
            System.out.println("1. Book Ticket");
            System.out.println("2. Cancel Ticket");
            System.out.println("3. Show All Tickets");
            System.out.println("4. Search Ticket");
            System.out.println("5. Count Total Tickets");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            int id;
            String name, movie, seat, time;

            switch (choice) {
                case 1:
                    System.out.print("Enter Ticket ID: ");
                    id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Customer Name: ");
                    name = sc.nextLine();
                    System.out.print("Enter Movie Name: ");
                    movie = sc.nextLine();
                    System.out.print("Enter Seat Number: ");
                    seat = sc.nextLine();
                    System.out.print("Enter Booking Time: ");
                    time = sc.nextLine();
                    system.addTicket(id, name, movie, seat, time);
                    break;

                case 2:
                    System.out.print("Enter Ticket ID to cancel: ");
                    id = sc.nextInt();
                    system.removeTicket(id);
                    break;

                case 3:
                    system.displayTickets();
                    break;

                case 4:
                    System.out.print("Enter Customer Name or Movie Name to search: ");
                    String keyword = sc.nextLine();
                    system.searchTicket(keyword);
                    break;

                case 5:
                    System.out.println("Total Tickets Booked: " + system.totalTickets());
                    break;

                case 6:
                    System.out.println("Exiting system.");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 6);

        sc.close();
    }
}
