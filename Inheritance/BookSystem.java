//Superclass
class Book {
    String title;
    int publicationYear;
    
    //Constructor
    Book(String title, int publicationYear) {
        this.title = title;
        this.publicationYear = publicationYear;
    }
    //Method to display info
    void displayInfo() {
        System.out.println("Book Title: " + title);
        System.out.println("Publication Year: " + publicationYear);
    }
}

//Subclass Author
class Author extends Book {
    String name;
    String bio;

    Author(String title, int publicationYear, String name, String bio) {
        super(title,publicationYear);
        this.name = name;
        this.bio = bio;
    }
    @Override
    void displayInfo() {
        super.displayInfo();
        System.out.println("Author Name: " + name);
        System.out.println("Author Bio: " + bio);
    }
}
//Main class to test
public class BookSystem {
    public static void main(String[] args) {
        Author book = new Author("The Guide", 1987, "R.K.Narayan", "R. K. Narayan was an Indian writer known for his works set in fictional South Indian town Malgudi.");
        System.out.println("=== Book and Author Information ===");
        book.displayInfo();
    }

}









