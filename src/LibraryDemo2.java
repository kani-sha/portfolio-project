import components.Library1L;

/**
 * Library Demo 2.
 */
public final class LibraryDemo2 {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private LibraryDemo2() {
    }

    /**
     * Main method to demonstrate library functionality.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Library1L library = new Library1L();

        Library1L.Booky book1 = new Library1L.Booky("Moby Dick",
                "Herman Melville", "15 hours", "Adventure", 585, 4.3, 200);
        Library1L.Booky book2 = new Library1L.Booky("War and Peace",
                "Leo Tolstoy", "20 hours", "Historical", 1225, 4.4, 300);
        Library1L.Booky book3 = new Library1L.Booky("The Catcher in the Rye",
                "J.D. Salinger", "7 hours", "Fiction", 214, 4.0, 50);
        Library1L.Booky book4 = new Library1L.Booky("The Great Gatsby",
                "F. Scott Fitzgerald", "5 hours", "Classic", 180, 4.2, 0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        System.out.println("Library Demo 2");
        System.out.println();
        System.out.println("Total books: " + library.size());

        library.removeBook(book2);

        System.out.println(
                "Updated Total books after removal: " + library.size());

        System.out.println();
        System.out.println("Reading progress:");
        for (int i = 0; i < library.size(); i++) {
            Library1L.Booky b = (Library1L.Booky) library.get(i);
            double progress = library.readingProgress(b, b.getPages());
            System.out.printf("%s: %.1f%% (%d/%d)%n", b.getTitle(), progress,
                    b.getPagesRead(), b.getPages());
        }

        System.out.println();
        System.out.println("Books by selected genres:");
        java.util.List<?> genres = library.listByGenre();
        if (genres.isEmpty()) {
            System.out.println("  (none)");
        } else {
            for (Object o : genres) {
                Library1L.Booky b = (Library1L.Booky) o;
                System.out.println(
                        "  - " + b.getTitle() + " [" + b.getGenre() + "]");
            }
        }

        library.toString();

    }

}
