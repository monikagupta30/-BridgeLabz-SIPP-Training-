class Book {
    // Static variable shared by all books
    static String libraryName = "Central Public Library";

    // Final variable - unique and unchangeable for each book
    private final String isbn;

    // Instance variables
    private String title;
    private String author;

    // Constructor using 'this' keyword to resolve ambiguity
    public Book(String title, String author, String isbn) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
    }

    // Static method to display library name
    public static void displayLibraryName() {
        System.out.println("Library Name: " + libraryName);
    }

    // Method to display book details
    public void displayBookDetails() {
        System.out.println("Title : " + title);
        System.out.println("Author: " + author);
        System.out.println("ISBN  : " + isbn);
    }

    // Main method for testing
    public static void main(String[] args) {
        Book book1 = new Book("The Alchemist", "Paulo Coelho", "9780061122415");
        Book book2 = new Book("1984", "George Orwell", "9780451524935");

        // Display library name (static method)
        Book.displayLibraryName();

        // Use instanceof to check before displaying details
        if (book1 instanceof Book) {
            book1.displayBookDetails();
        }

        if (book2 instanceof Book) {
            book2.displayBookDetails();
        }
    }
}
