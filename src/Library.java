import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a simple library component.
 *
 */
class Book {

    private String title;
    private String author;
    private String estimatedTime;
    private int pages;
    private double rating;
    private int pagesRead;

    /*
     * Constructor --------------------------------------------
     */

    public Book(String title, String author, String estimatedTime, int pages,
            double rating, int pagesRead) {
        this.title = title;
        this.author = author;
        this.estimatedTime = estimatedTime;
        this.pages = pages;
        this.rating = rating;
        this.pagesRead = 0;
    }

    /*
     * Getters & Setters --------------------------------------
     */
    public String getTitle() {
        return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getEstimatedTime() {
        return this.estimatedTime;
    }

    public int getPages() {
        return this.pages;
    }

    public double getRating() {
        return this.rating;
    }

    public int getPagesRead() {
        return this.pagesRead;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setEstimatedTime(String estimatedTime) {
        this.estimatedTime = estimatedTime;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public void setPagesRead(int pagesRead) {
        this.pagesRead = pagesRead;
    }

}

/**
 * Represents the library that manages a collection of Book objects.
 */
public class Library {

    /**
     * The collection of books in the library.
     */
    private List<Book> books = new ArrayList<>();

    /*
     * Kernel methods -----------------------------------------
     */

    /**
     * Adds a book to the library.
     *
     * @param book
     *            the book being added to the library
     */
    public void addBook(Book book) {
        this.books.add(book);
    }

    /**
     * Removes a book from the library.
     *
     * @param title
     *            the title of the book being removed from the library
     */
    public void removeBook(String title) {
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getTitle().equals(title)) {
                this.books.remove(i);
            }
        }
    }

    /**
     * Finds a book in the library.
     *
     * @param title
     *            the title of the book being searched for
     */
    public void findBook(String title) {
        boolean found = false;
        for (int i = 0; i < this.books.size(); i++) {
            Book book = this.books.get(i);
            if (book.getTitle().equals(title)) {
                System.out.println("This book is in your library: "
                        + this.books.get(i).getTitle());
                found = true;
            }
        }

        if (!found) {
            System.out.println("This book is not in your library.");
        }
    }

    /*
     * Secondary methods ---------------------------------------
     */

    /**
     * Returns the ranking of the book based on user ratings.
     *
     */
    public void bookRanking() {
        Collections.sort(this.books,
                Comparator.comparingDouble(Book::getRating).reversed());
        for (int i = 0; i < this.books.size(); i++) {
            String title = this.books.get(i).getTitle();
            double rating = this.books.get(i).getRating();
            if (rating >= 4.5) {
                System.out.println(title + " - Excellent");
            } else if (rating >= 3.5) {
                System.out.println(title + " - Good");
            } else if (rating >= 2.5) {
                System.out.println(title + " - Average");
            } else {
                System.out.println(title + " - Poor");
            }
        }
    }

    /**
     * Tracks reading progress of a book.
     *
     * @param book
     *            the book being tracked
     * @param pagesRead
     *            the number of pages read so far
     */
    public void readingProgress(Book book, int pagesRead) {
        book.setPagesRead(pagesRead);
        double progress = ((double) pagesRead / book.getPages()) * 100;
        System.out.printf("You have read %.2f%% of %s.%n", progress,
                book.getTitle());
    }

    /**
     * Main method for the Library interface.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Library Component!");
        Library library = new Library();
        Book b1 = new Book("Motherthing", "Ainslie Hogarth", "5 hours", 288,
                4.5, 30);
        Book b2 = new Book("Watchmen", "Alan Moore", "6 hours", 448, 4.8, 100);
        Book b3 = new Book("1984", "George Orwell", "4 hours", 330, 4.2, 50);
        library.addBook(b1);
        library.addBook(b2);
        library.addBook(b3);

        library.findBook("1984");

        library.bookRanking();

        library.readingProgress(b1, 30);

    }
}