import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import components.Library1L;

/**
 * JUnit test fixture for {@code Library}.
 */
public class LibraryTest {

    /**
     * Test bookRanking returns books sorted by rating (highest first).
     */
    @Test
    public void testBookRankingByRating() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("Book A", "Author A",
                "5 hours", "Fiction", 200, 3.5, 50);
        Library1L.Booky book2 = new Library1L.Booky("Book B", "Author B",
                "6 hours", "Fiction", 250, 4.8, 100);
        Library1L.Booky book3 = new Library1L.Booky("Book C", "Author C",
                "7 hours", "Fiction", 300, 2.5, 150);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<?> ranked = library.bookRanking();
        assertEquals(3, ranked.size());
        // Verify order: 4.8, 3.5, 2.5 (highest to lowest)
        assertEquals(book2, ranked.get(0));
        assertEquals(book1, ranked.get(1));
        assertEquals(book3, ranked.get(2));
    }

    /**
     * Test bookRanking with single book.
     */
    @Test
    public void testBookRankingSingleBook() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Solo Book", "Author",
                "4 hours", "Fiction", 150, 4.0, 0);
        library.addBook(book);

        List<?> ranked = library.bookRanking();
        assertEquals(1, ranked.size());
        assertEquals(book, ranked.get(0));
    }

    /**
     * Test bookRanking with equal ratings.
     */
    @Test
    public void testBookRankingEqualRatings() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("Book A", "Author A",
                "5 hours", "Fiction", 200, 4.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("Book B", "Author B",
                "6 hours", "Fiction", 250, 4.5, 0);

        library.addBook(book1);
        library.addBook(book2);

        List<?> ranked = library.bookRanking();
        assertEquals(2, ranked.size());

        // Both have same rating; either order is acceptable
        assertEquals(4.5, ((Library1L.Booky) ranked.get(0)).getRating(), 0.001);
        assertEquals(4.5, ((Library1L.Booky) ranked.get(1)).getRating(), 0.001);
    }

    /**
     * Test estimateReadingTime calculates hours correctly.
     */
    @Test
    public void testEstimateReadingTime() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Book", "Author", "5 hours",
                "Fiction", 250, 4.0, 0);

        int avgSpeed = 50; // pages per hour
        int hours = library.estimateReadingTime(book, avgSpeed);
        assertEquals(5, hours); // 250 pages / 50 = 5 hours
    }

    /**
     * Test estimateReadingTime with different reading speeds.
     */
    @Test
    public void testEstimateReadingTimeVariousSpeeds() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Book", "Author", "4 hours",
                "Fiction", 300, 4.0, 0);

        assertEquals(3, library.estimateReadingTime(book, 100)); // 300 / 100 = 3
        assertEquals(6, library.estimateReadingTime(book, 50)); // 300 / 50 = 6
        assertEquals(10, library.estimateReadingTime(book, 30)); // 300 / 30 = 10
    }

    /**
     * Test estimateReadingTime with single page book.
     */
    @Test
    public void testEstimateReadingTimeSinglePage() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Short", "Author", "1 hour",
                "Fiction", 1, 5.0, 0);

        int hours = library.estimateReadingTime(book, 50);
        assertEquals(0, hours); // 1 page / 50 = 0 hours
    }

    /**
     * Test readingProgress calculates percentage correctly.
     */
    @Test
    public void testReadingProgress() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Book", "Author", "5 hours",
                "Fiction", 200, 4.0, 100);

        double progress = library.readingProgress(book, 200);
        assertEquals(50.0, progress, 0.001); // 100 / 200 * 100 = 50%
    }

    /**
     * Test readingProgress with no pages read.
     */
    @Test
    public void testReadingProgressZero() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Book", "Author", "5 hours",
                "Fiction", 200, 4.0, 0);

        double progress = library.readingProgress(book, 200);
        assertEquals(0.0, progress, 0.001); // 0 / 200 * 100 = 0%
    }

    /**
     * Test readingProgress with all pages read.
     */
    @Test
    public void testReadingProgressComplete() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Book", "Author", "5 hours",
                "Fiction", 200, 4.0, 200);

        double progress = library.readingProgress(book, 200);
        assertEquals(100.0, progress, 0.001); // 200 / 200 * 100 = 100%
    }

    /**
     * Test readingProgress with partial reading.
     */
    @Test
    public void testReadingProgressPartial() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Book", "Author", "5 hours",
                "Fiction", 300, 4.0, 75);

        double progress = library.readingProgress(book, 300);
        assertEquals(25.0, progress, 0.001); // 75 / 300 * 100 = 25%
    }

    /**
     * Test listByGenre returns only books in specified genres.
     */
    @Test
    public void testListByGenre() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("Horror1", "Author1",
                "5 hours", "Horror", 200, 3.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("Romance1", "Author2",
                "6 hours", "Romance", 250, 4.0, 0);
        Library1L.Booky book3 = new Library1L.Booky("SciFi", "Author3",
                "7 hours", "Science Fiction", 300, 3.8, 0);
        Library1L.Booky book4 = new Library1L.Booky("Fantasy1", "Author4",
                "8 hours", "Fantasy", 350, 4.2, 0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);
        library.addBook(book4);

        List<?> genreBooks = library.listByGenre();

        // Should contain Horror, Romance, Science Fiction, Fantasy (matches filter)
        assertEquals(4, genreBooks.size());
        assertTrue(genreBooks.contains(book1)); // Horror
        assertTrue(genreBooks.contains(book2)); // Romance
        assertTrue(genreBooks.contains(book3)); // Science Fiction
        assertTrue(genreBooks.contains(book4)); // Fantasy
    }

    /**
     * Test listByGenre with no matching genres.
     */
    @Test
    public void testListByGenreNoMatches() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("Random", "Author",
                "5 hours", "Nonexistent", 200, 4.0, 0);
        library.addBook(book);

        List<?> genreBooks = library.listByGenre();
        assertEquals(0, genreBooks.size());
    }

    /**
     * Test listByGenre with mixed genres.
     */
    @Test
    public void testListByGenreMixed() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("Dystopian1", "Author1",
                "6 hours", "Dystopian", 300, 4.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("Adventure", "Author2",
                "7 hours", "Adventure", 350, 4.3, 0);
        Library1L.Booky book3 = new Library1L.Booky("Classic1", "Author3",
                "5 hours", "Classic", 250, 4.7, 0);

        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        List<?> genreBooks = library.listByGenre();

        // All three should match (Dystopian, Adventure, Classic all in filter)
        assertEquals(3, genreBooks.size());
        assertTrue(genreBooks.contains(book1));
        assertTrue(genreBooks.contains(book2));
        assertTrue(genreBooks.contains(book3));
    }

    /**
     * Test listByGenre after removing a book.
     */
    @Test
    public void testListByGenreAfterRemoval() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("Horror1", "Author1",
                "5 hours", "Horror", 200, 3.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("Horror2", "Author2",
                "6 hours", "Horror", 250, 4.0, 0);

        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.listByGenre().size());

        library.removeBook(book1);
        List<?> genreBooks = library.listByGenre();
        assertEquals(1, genreBooks.size());
        assertEquals(book2, genreBooks.get(0));
    }

    /**
     * Test toString returns the titles joined by newlines and ends with
     * newline.
     */
    @Test
    public void testToString() {
        Library1L library = new Library1L();
        Library1L.Booky a = new Library1L.Booky("TitleA", "A", "1h", "Fiction",
                100, 4.0, 0);
        Library1L.Booky b = new Library1L.Booky("TitleB", "B", "1h", "Fiction",
                120, 4.1, 0);
        library.addBook(a);
        library.addBook(b);

        String s = library.toString();
        assertTrue(s.contains("TitleA"));
        assertTrue(s.contains("TitleB"));
        // Current implementation appends a newline after each title
        assertTrue(s.endsWith("\n"));
    }

    /**
     * Test equals for libraries: same object references in same order => equal.
     */
    @Test
    public void testEqualsSameContents() {
        Library1L lib1 = new Library1L();
        Library1L lib2 = new Library1L();
        Library1L.Booky b1 = new Library1L.Booky("X", "A", "1h", "Fiction", 100,
                4.0, 0);
        Library1L.Booky b2 = new Library1L.Booky("Y", "B", "1h", "Fiction", 150,
                3.5, 0);

        // add same references to both libraries
        lib1.addBook(b1);
        lib1.addBook(b2);
        lib2.addBook(b1);
        lib2.addBook(b2);

        assertTrue(lib1.equals(lib2));
        assertTrue(lib2.equals(lib1));
    }

    /**
     * Test equals is sensitive to order: same refs but different order -> not
     * equal.
     */
    @Test
    public void testEqualsDifferentOrder() {
        Library1L lib1 = new Library1L();
        Library1L lib2 = new Library1L();
        Library1L.Booky b1 = new Library1L.Booky("X", "A", "1h", "Fiction", 100,
                4.0, 0);
        Library1L.Booky b2 = new Library1L.Booky("Y", "B", "1h", "Fiction", 150,
                3.5, 0);

        lib1.addBook(b1);
        lib1.addBook(b2);

        lib2.addBook(b2);
        lib2.addBook(b1);

        assertTrue(!lib1.equals(lib2));
        assertTrue(!lib2.equals(lib1));
    }

}
