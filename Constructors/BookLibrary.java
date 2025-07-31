// Base class
class Book {
    public String ISBN;          // Public - accessible anywhere
    protected String title;      // Protected - accessible in subclass
    private String author;       // Private - accessed via public methods

    // Constructor
    public Book(String ISBN, String title, String author) {
        this.ISBN = ISBN;
        this.title = title;
        this.author = author;
    }

    // Public getter for author
    public String getAuthor() {
        return author;
    }

    // Public setter for author
    public void setAuthor(String author) {
        this.author = author;
    }

    // Method to display book info
    public void displayBookInfo() {
        System.out.println("ISBN   : " + ISBN);
        System.out.println("Title  : " + title);
        System.out.println("Author : " + author);
        System.out.println();
    }
}

// Subclass
class EBook extends Book {
    private double fileSize;

    // Constructor for EBook
    public EBook(String ISBN, String title, String author, double fileSize) {
        super(ISBN, title, author);
        this.fileSize = fileSize;
    }

    // Method to display EBook details using public and protected members
    public void displayEBookInfo() {
        System.out.println("E-Book Access:");
        System.out.println("ISBN     : " + ISBN);       // public – accessible
        System.out.println("Title    : " + title);       // protected – accessible in subclass
        // System.out.println("Author : " + author);     // Not allowed – author is private
        System.out.println("File Size: " + fileSize + " MB");
        System.out.println();
    }
}

// Main class
class BookLibrarySystem {
    public static void main(String[] args) {
        // Create a Book object
        Book book1 = new Book("978-0134685991", "Effective Java", "Joshua Bloch");
        book1.displayBookInfo();

        // Modify author using setter
        book1.setAuthor("J. Bloch");
        System.out.println("Updated Author: " + book1.getAuthor());
        System.out.println();

        // Create an EBook object
        EBook ebook1 = new EBook("978-0134685991", "Effective Java (EBook)", "Joshua Bloch", 5.6);
        ebook1.displayEBookInfo();
    }
}
