import java.util.Scanner;

class MovieNode {
    String title, director;
    int year;
    double rating;
    MovieNode prev, next;

    public MovieNode(String title, String director, int year, double rating) {
        this.title = title;
        this.director = director;
        this.year = year;
        this.rating = rating;
        this.prev = this.next = null;
    }
}

class MovieList {
    MovieNode head = null, tail = null;

    // Add at beginning
    void addAtBeginning(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        System.out.println("Movie added at beginning.");
    }

    // Add at end
    void addAtEnd(String title, String director, int year, double rating) {
        MovieNode newNode = new MovieNode(title, director, year, rating);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        System.out.println("Movie added at end.");
    }

    // Add at position (1-based)
    void addAtPosition(int position, String title, String director, int year, double rating) {
        if (position <= 1) {
            addAtBeginning(title, director, year, rating);
            return;
        }

        MovieNode newNode = new MovieNode(title, director, year, rating);
        MovieNode temp = head;
        int count = 1;

        while (temp != null && count < position - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null || temp.next == null) {
            addAtEnd(title, director, year, rating);
        } else {
            newNode.next = temp.next;
            newNode.prev = temp;
            temp.next.prev = newNode;
            temp.next = newNode;
            System.out.println("Movie added at position " + position);
        }
    }

    // Remove by title
    void removeByTitle(String title) {
        MovieNode temp = head;

        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
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
                System.out.println("Movie \"" + title + "\" removed.");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Search by director
    void searchByDirector(String director) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.director.equalsIgnoreCase(director)) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found for director: " + director);
    }

    // Search by rating
    void searchByRating(double rating) {
        MovieNode temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.rating == rating) {
                displayMovie(temp);
                found = true;
            }
            temp = temp.next;
        }
        if (!found) System.out.println("No movies found with rating: " + rating);
    }

    // Update rating by title
    void updateRating(String title, double newRating) {
        MovieNode temp = head;
        while (temp != null) {
            if (temp.title.equalsIgnoreCase(title)) {
                temp.rating = newRating;
                System.out.println("Rating updated for movie \"" + title + "\".");
                return;
            }
            temp = temp.next;
        }
        System.out.println("Movie not found.");
    }

    // Display forward
    void displayForward() {
        if (head == null) {
            System.out.println("Movie list is empty.");
            return;
        }
        System.out.println("--- Movie List (Forward) ---");
        MovieNode temp = head;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.next;
        }
    }

    // Display reverse
    void displayReverse() {
        if (tail == null) {
            System.out.println("Movie list is empty.");
            return;
        }
        System.out.println("--- Movie List (Reverse) ---");
        MovieNode temp = tail;
        while (temp != null) {
            displayMovie(temp);
            temp = temp.prev;
        }
    }

    // Display a single movie
    void displayMovie(MovieNode movie) {
        System.out.println("Title: " + movie.title + ", Director: " + movie.director + ", Year: " + movie.year + ", Rating: " + movie.rating);
    }
}

public class MovieManagementSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MovieList list = new MovieList();

        int choice;
        do {
            System.out.println("\n--- Movie Management System ---");
            System.out.println("1. Add Movie at Beginning");
            System.out.println("2. Add Movie at End");
            System.out.println("3. Add Movie at Position");
            System.out.println("4. Remove Movie by Title");
            System.out.println("5. Search by Director");
            System.out.println("6. Search by Rating");
            System.out.println("7. Display Movies Forward");
            System.out.println("8. Display Movies Reverse");
            System.out.println("9. Update Movie Rating");
            System.out.println("10. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine();  // Clear newline

            String title, director;
            int year, pos;
            double rating;

            switch (choice) {
                case 1:
                    System.out.print("Enter Title: "); title = sc.nextLine();
                    System.out.print("Enter Director: "); director = sc.nextLine();
                    System.out.print("Enter Year: "); year = sc.nextInt();
                    System.out.print("Enter Rating: "); rating = sc.nextDouble();
                    list.addAtBeginning(title, director, year, rating);
                    break;
                case 2:
                    System.out.print("Enter Title: "); title = sc.nextLine();
                    System.out.print("Enter Director: "); director = sc.nextLine();
                    System.out.print("Enter Year: "); year = sc.nextInt();
                    System.out.print("Enter Rating: "); rating = sc.nextDouble();
                    list.addAtEnd(title, director, year, rating);
                    break;
                case 3:
                    System.out.print("Enter Position: "); pos = sc.nextInt(); sc.nextLine();
                    System.out.print("Enter Title: "); title = sc.nextLine();
                    System.out.print("Enter Director: "); director = sc.nextLine();
                    System.out.print("Enter Year: "); year = sc.nextInt();
                    System.out.print("Enter Rating: "); rating = sc.nextDouble();
                    list.addAtPosition(pos, title, director, year, rating);
                    break;
                case 4:
                    System.out.print("Enter Title to Remove: ");
                    title = sc.nextLine();
                    list.removeByTitle(title);
                    break;
                case 5:
                    System.out.print("Enter Director Name: ");
                    director = sc.nextLine();
                    list.searchByDirector(director);
                    break;
                case 6:
                    System.out.print("Enter Rating to Search: ");
                    rating = sc.nextDouble();
                    list.searchByRating(rating);
                    break;
                case 7:
                    list.displayForward();
                    break;
                case 8:
                    list.displayReverse();
                    break;
                case 9:
                    System.out.print("Enter Movie Title to Update Rating: ");
                    title = sc.nextLine();
                    System.out.print("Enter New Rating: ");
                    rating = sc.nextDouble();
                    list.updateRating(title, rating);
                    break;
                case 10:
                    System.out.println("Exiting Movie Management System.");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }

        } while (choice != 10);

        sc.close();
    }
}
