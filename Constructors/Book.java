class Book {
    // Attributes
    private String title;
    private String author;
    private double price;

    // Default constructor
    public Book() {
        this.title = "Unknown";
        this.author = "Unknown";
        this.price = 0.0;
    }

    // Parameterized constructor
    public Book(String title, String author, double price) {
        this.title = title;
        this.author = author;
        this.price = price;
    }

    // Method to display book details
    public void displayDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("Price : ₹" + price);
    }

    // Main method to test the Book class
    public static void main(String[] args) {
        // Using default constructor
        Book defaultBook = new Book();
        System.out.println("Default Book:");
        defaultBook.displayDetails();

        System.out.println();

        // Using parameterized constructor
        Book customBook = new Book("The Alchemist", "Paulo Coelho", 399.99);
        System.out.println("Custom Book:");
        customBook.displayDetails();
    }
}
