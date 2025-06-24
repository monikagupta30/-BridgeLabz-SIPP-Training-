class Book {
    // Attributes
    private String title;
    private String author;
    private double price;
    private boolean availability;

    // Parameterized constructor
    public Book(String title, String author, double price, boolean availability) {
        this.title = title;
        this.author = author;
        this.price = price;
        this.availability = availability;
    }

    // Method to borrow the book
    public void borrowBook() {
        if (availability) {
            availability = false;
            System.out.println("Book borrowed successfully: " + title);
        } else {
            System.out.println("Sorry, the book \"" + title + "\" is currently not available.");
        }
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title       : " + title);
        System.out.println("Author      : " + author);
        System.out.println("Price       : ₹" + price);
        System.out.println("Availability: " + (availability ? "Available" : "Not Available"));
        System.out.println();
    }

    // Main method for testing
    public static void main(String[] args) {
        // Create a book
        Book book1 = new Book("Clean Code", "Robert C. Martin", 599.99, true);

        // Display details
        System.out.println("Book Info:");
        book1.displayDetails();

        // Borrow the book
        System.out.println("Attempting to borrow...");
        book1.borrowBook();

        // Try borrowing again
        System.out.println("Attempting to borrow again...");
        book1.borrowBook();

        // Show updated details
        System.out.println("\nUpdated Book Info:");
        book1.displayDetails();
    }
}
