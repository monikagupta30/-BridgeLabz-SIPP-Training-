import java.util.ArrayList;

class LibraryAggregationDemo {

    // Book class
    static class Book {
        private String title;
        private String author;

        // Constructor
        public Book(String title, String author) {
            this.title = title;
            this.author = author;
        }

        // Display book info
        public void displayBook() {
            System.out.println("Title: " + title + ", Author: " + author);
        }
    }

    // Library class
    static class Library {
        private String name;
        private ArrayList<Book> books;

        // Constructor
        public Library(String name) {
            this.name = name;
            this.books = new ArrayList<>();
        }

        // Add a book to the library
        public void addBook(Book book) {
            books.add(book);
        }

        // Display all books in the library
        public void displayLibrary() {
            System.out.println("Library: " + name);
            System.out.println("Books in the library:");
            for (Book book : books) {
                book.displayBook();
            }
            System.out.println();
        }
    }

    // Main method
    public static void main(String[] args) {
        // Create books independently
        Book b1 = new Book("The Alchemist", "Paulo Coelho");
        Book b2 = new Book("Clean Code", "Robert C. Martin");
        Book b3 = new Book("Java Basics", "James Gosling");

        // Create libraries
        Library lib1 = new Library("City Library");
        Library lib2 = new Library("University Library");

        // Add books to libraries
        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2); // same book in another library
        lib2.addBook(b3);

        // Display libraries
        lib1.displayLibrary();
        lib2.displayLibrary();
    }
}
