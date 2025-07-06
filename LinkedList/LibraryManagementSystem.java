import java.util.Scanner;

class BookNode {
    String title, author, genre, status;
    int bookId;
    BookNode prev, next;

    public BookNode(String title, String author, String genre, int bookId, String status) {
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.bookId = bookId;
        this.status = status;
        this.prev = this.next = null;
    }
}

class Library {
    BookNode head = null, tail = null;

    // Add book at beginning
    void addAtBeginning(String title, String author, String genre, int bookId, String status) {
        BookNode newNode = new BookNode(title, author, genre, bookId, status);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Book added at beginning.");
    }

    // Add book at end
    void addAtEnd(String title, String author, String genre, int bookId, String status) {
        BookNode newNode = new BookNode(title, author, genre, bookId, status);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Book added at end.");
    }

    // Add at position (1-based)
    void addAtPosition(int position, String title, String author, String genre, int bookId, String status) {
        if (position <= 1 || head == null) {
            addAtBeginning(title, author, genre, bookId, status);
            return;
        }

        BookNode newNode = new BookNode(title, author, genre, bookId, status);
        BookNode temp = head;
        int count = 1;

        while (temp.next != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp.next == null) {
            addAtEnd(title, author, genre, bookId, status);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            System.out.println("Book added at position " + position);
        }
    }

    // Remove by Book ID
    void removeById(int bookId) {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                if (temp == head) {
                    head = head.next;
                    if (head != null) head.prev = null;
                    else tail = null;
                } else if (temp == tail) {
                    tail = tail.prev;
                    tail.next = null;
                } else {
                    temp.prev.next = temp.next;
                    temp.next.prev = temp.prev;
                }
                System.out.println("Book with ID " + bookId + " removed.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book ID not found.");
    }

    // Search by Title
    void searchByTitle(String title) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("Book with title \"" + title + "\" not found.");
    }

    // Search by Author
    void searchByAuthor(String author) {
        BookNode temp = head;
        boolean found = false;

        while (temp != null) {
            if (temp.author.equalsIgnoreCase(author)) {
                displayBook(temp);
                found = true;
            }
            temp = temp.next;
        }

        if (!found) System.out.println("Books by author \"" + author + "\" not found.");
    }

    // Update Availability Status
    void updateStatus(int bookId, String newStatus) {
        BookNode temp = head;

        while (temp != null) {
            if (temp.bookId == bookId) {
                temp.status = newStatus;
                System.out.println("Availability status updated.");
                return;
            }
            temp = temp.next;
        }

        System.out.println("Book ID not found.");
    }

    // Display forward
    void displayForward() {
        if (head == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("--- Book List (Forward) ---");
        BookNode temp = head;
        while (temp != null) {
            displayBook(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {
        if (tail == null) {
            System.out.println("Library is empty.");
            return;
        }

        System.out.println("--- Book List (Reverse) ---");
        BookNode temp = tail;
        while (temp != null) {
            displayBook(temp);
            temp = temp.prev;
        }
    }

    // Count total books
    void countBooks() {
        int count = 0;
        BookNode temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        System.out.println("Total number of books: " + count);
    }

    // Display a single book
    void displayBook(BookNode book) {
        System.out.println("ID: " + book.bookId + ", Title: " + book.title +
                ", Author: " + book.author + ", Genre: " + book.genre +
                ", Availability: " + book.status);
    }
}

public class LibraryManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Library library = new Library();
        int choice;

        do {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book at Beginning");
            System.out.println("2. Add Book at End");
            System.out.println("3. Add Book at Position");
            System.out.println("4. Remove Book by ID");
            System.out.println("5. Search Book by Title");
            System.out.println("6. Search Book by Author");
            System.out.println("7. Update Availability Status");
            System.out.println("8. Display Books Forward");
            System.out.println("9. Display Books Reverse");
            System.out.println("10. Count Total Books");
            System.out.println("11. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            String title, author, genre, status;
            int id, pos;

            switch (choice) {
                case 1:
                    System.out.print("Title: "); title = sc.nextLine();
                    System.out.print("Author: "); author = sc.nextLine();
                    System.out.print("Genre: "); genre = sc.nextLine();
                    System.out.print("Book ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Status (Available/Issued): "); status = sc.nextLine();
                    library.addAtBeginning(title, author, genre, id, status);
                    break;
                case 2:
                    System.out.print("Title: "); title = sc.nextLine();
                    System.out.print("Author: "); author = sc.nextLine();
                    System.out.print("Genre: "); genre = sc.nextLine();
                    System.out.print("Book ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Status (Available/Issued): "); status = sc.nextLine();
                    library.addAtEnd(title, author, genre, id, status);
                    break;
                case 3:
                    System.out.print("Position: "); pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Title: "); title = sc.nextLine();
                    System.out.print("Author: "); author = sc.nextLine();
                    System.out.print("Genre: "); genre = sc.nextLine();
                    System.out.print("Book ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Status (Available/Issued): "); status = sc.nextLine();
                    library.addAtPosition(pos, title, author, genre, id, status);
                    break;
                case 4:
                    System.out.print("Enter Book ID to remove: "); id = sc.nextInt();
                    library.removeById(id);
                    break;
                case 5:
                    System.out.print("Enter Book Title: "); title = sc.nextLine();
                    library.searchByTitle(title);
                    break;
                case 6:
                    System.out.print("Enter Author Name: "); author = sc.nextLine();
                    library.searchByAuthor(author);
                    break;
                case 7:
                    System.out.print("Enter Book ID: "); id = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter New Status: "); status = sc.nextLine();
                    library.updateStatus(id, status);
                    break;
                case 8:
                    library.displayForward();
                    break;
                case 9:
                    library.displayReverse();
                    break;
                case 10:
                    library.countBooks();
                    break;
                case 11:
                    System.out.println("Exiting Library System.");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        } while (choice != 11);

        sc.close();
    }
}
