import components.Library1L;

/**
 * Library Demo 1.
 */
public final class LibraryDemo1 {

    /**
     * Private constructor to prevent instantiation of this utility class.
     */
    private LibraryDemo1() {
    }

    /**
     * Main method to demonstrate library functionality.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        Library1L library = new Library1L();

        Library1L.Booky book1 = new Library1L.Booky("The Hobbit",
                "J.R.R. Tolkien", "10 hours", "Fantasy", 310, 4.9, 50);
        Library1L.Booky book2 = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        Library1L.Booky book3 = new Library1L.Booky("To Kill a Mockingbird",
                "Harper Lee", "8 hours", "Classic", 281, 4.8, 100);
        Library1L.Booky book4 = new Library1L.Booky("Pride and Prejudice",
                "Jane Austen", "7 hours", "Romance", 279, 4.6, 150);
        Library1L.Booky book5 = new Library1L.Booky("The Shining",
                "Stephen King", "12 hours", "Horror", 447, 4.7, 200);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);
        library.addBook(book5);

        System.out.println("Library Demo 1");
        System.out.println();
        System.out.println("Total books: " + library.size());

        System.out.println();
        System.out.println("Ranking (by rating):");
        java.util.List<?> ranked = library.bookRanking();
        for (int i = 0; i < ranked.size(); i++) {
            Object o = ranked.get(i);
            System.out.println((i + 1) + ". " + ((Library1L.Booky) o).getTitle()
                    + " - " + ((Library1L.Booky) o).getRating());
        }

        System.out.println();
        System.out.println("Estimated reading time (pages/hour = 50):");
        int avgSpeed = 50;
        for (int i = 0; i < library.size(); i++) {
            Library1L.Booky b = (Library1L.Booky) library.get(i);
            int hours = library.estimateReadingTime(b, avgSpeed);
            System.out.println(b.getTitle() + ": ~" + hours + " hours");
        }
        System.out.println();
        System.out.println("Reading progress:");
        for (int i = 0; i < library.size(); i++) {
            Library1L.Booky b = (Library1L.Booky) library.get(i);
            double progress = library.readingProgress(b, b.getPages());
            System.out.printf("%s: %.1f%% (%d/%d)%n", b.getTitle(), progress,
                    b.getPagesRead(), b.getPages());
        }

        System.out.println();
        System.out.println("Demonstrating equals():");

        // Create a second library and add the same book references in same order
        Library1L lib2 = new Library1L();
        lib2.addBook(book1);
        lib2.addBook(book2);
        lib2.addBook(book3);
        lib2.addBook(book4);
        lib2.addBook(book5);

        System.out.println("library equal lib2? : " + library.equals(lib2));

        // Change order in lib3 and show inequality
        Library1L lib3 = new Library1L();
        lib3.addBook(book2);
        lib3.addBook(book1);
        lib3.addBook(book3);
        lib3.addBook(book4);
        lib3.addBook(book5);

        System.out.println("library equal lib3? : " + library.equals(lib3));

    }
}