import java.util.*;

// Interface for reservable items
interface Reservable {
    void reserveItem(String borrowerName);
    boolean checkAvailability();
}

// Abstract class for all library items
abstract class LibraryItem {
    private String itemId;
    private String title;
    private String author;

    // Encapsulated personal data
    private String borrower;

    // Constructor
    public LibraryItem(String itemId, String title, String author) {
        this.itemId = itemId;
        this.title = title;
        this.author = author;
        this.borrower = null;
    }

    // Getters
    public String getItemId() {
        return itemId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getBorrower() {
        return borrower;
    }

    // Abstract method
    public abstract int getLoanDuration(); // in days

    // Concrete method
    public void getItemDetails() {
        System.out.println("Item ID: " + itemId);
        System.out.println("Title: " + title);
        System.out.println("Author: " + author);
    }
}

// Book subclass
class Book extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public Book(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 14;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            setBorrower(borrowerName);
            System.out.println(borrowerName + " reserved the book \"" + getTitle() + "\".");
        } else {
            System.out.println("Book \"" + getTitle() + "\" is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Magazine subclass
class Magazine extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public Magazine(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 7;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            setBorrower(borrowerName);
            System.out.println(borrowerName + " reserved the magazine \"" + getTitle() + "\".");
        } else {
            System.out.println("Magazine \"" + getTitle() + "\" is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// DVD subclass
class DVD extends LibraryItem implements Reservable {
    private boolean isReserved = false;

    public DVD(String itemId, String title, String author) {
        super(itemId, title, author);
    }

    @Override
    public int getLoanDuration() {
        return 3;
    }

    @Override
    public void reserveItem(String borrowerName) {
        if (!isReserved) {
            isReserved = true;
            setBorrower(borrowerName);
            System.out.println(borrowerName + " reserved the DVD \"" + getTitle() + "\".");
        } else {
            System.out.println("DVD \"" + getTitle() + "\" is already reserved.");
        }
    }

    @Override
    public boolean checkAvailability() {
        return !isReserved;
    }
}

// Main class to test the system
public class LibrarySystem {
    public static void main(String[] args) {
        List<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B001", "Java Programming", "James Gosling"));
        items.add(new Magazine("M001", "National Geographic", "Editorial Team"));
        items.add(new DVD("D001", "Interstellar", "Christopher Nolan"));

        // Use polymorphism
        for (LibraryItem item : items) {
            System.out.println("\n-----------------------------");
            item.getItemDetails();
            System.out.println("Loan Duration: " + item.getLoanDuration() + " days");

            if (item instanceof Reservable) {
                Reservable r = (Reservable) item;
                System.out.println("Available: " + (r.checkAvailability() ? "Yes" : "No"));
                r.reserveItem("Ravi");
            }

            if (item.getBorrower() != null) {
                System.out.println("Borrower: " + item.getBorrower());
            }
        }
    }
}
