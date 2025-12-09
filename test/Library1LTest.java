
import static org.junit.Assert.*;

import org.junit.Test;

import components.Library1L;

/**
 * JUnit test fixture for {@code Library1L}.
 */
public class Library1LTest {

    /**
     * Test constructor creates an empty library.
     */
    @Test
    public void testConstructor() {
        Library1L library = new Library1L();
        assertEquals(0, library.size());
    }

    /**
     * Test addBook adds a single book to empty library.
     */
    @Test
    public void testAddBookToEmpty() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        library.addBook(book);
        assertEquals(1, library.size());
        assertEquals(book, library.get(0));
    }

    /**
     * Test addBook adds multiple books.
     */
    @Test
    public void testAddMultipleBooks() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("To Kill a Mockingbird",
                "Harper Lee", "7 hours", "Classic", 336, 4.8, 0);
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.size());
        assertEquals(book1, library.get(0));
        assertEquals(book2, library.get(1));
    }

    /**
     * Test addBook with null throws exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testAddBookNull() {
        Library1L library = new Library1L();
        library.addBook(null);
    }

    /**
     * Test removeBook removes a book from library.
     */
    @Test
    public void testRemoveBook() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        library.addBook(book);
        library.removeBook(book);
        assertEquals(0, library.size());
    }

    @Test
    public void testRemoveBookMultiple() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("To Kill a Mockingbird",
                "Harper Lee", "7 hours", "Classic", 336, 4.8, 0);
        library.addBook(book1);
        library.addBook(book2);
        library.removeBook(book1);
        assertEquals(1, library.size());
        assertEquals(book2, library.get(0));
    }

    /**
     * Test removeBook with null throws exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveBookNull() {
        Library1L library = new Library1L();
        library.removeBook(null);
    }

    /**
     * Test removeBook with book not in library throws exception.
     */
    @Test(expected = IllegalArgumentException.class)
    public void testRemoveBookNotInLibrary() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        library.removeBook(book);
    }

    /**
     * Test findBook returns true when book exists.
     */
    @Test
    public void testFindBookExists() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        library.addBook(book);
        assertTrue(library.findBook("1984"));
    }

    /**
     * Test findBook returns false when book does not exist.
     */
    @Test
    public void testFindBookDoesNotExist() {
        Library1L library = new Library1L();
        assertFalse(library.findBook("1984"));
    }

    /**
     * Test findBook in library with multiple books.
     */
    @Test
    public void testFindBookMultipleBooks() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("To Kill a Mockingbird",
                "Harper Lee", "7 hours", "Classic", 336, 4.8, 0);
        library.addBook(book1);
        library.addBook(book2);
        assertTrue(library.findBook("1984"));
        assertTrue(library.findBook("To Kill a Mockingbird"));
        assertFalse(library.findBook("The Great Gatsby"));
    }

    /**
     * Test Book getTitle method.
     */
    @Test
    public void testBookGetTitle() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        assertEquals("1984", book.getTitle());
    }

    /**
     * Test Book getAuthor method.
     */
    @Test
    public void testBookGetAuthor() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        assertEquals("George Orwell", book.getAuthor());
    }

    /**
     * Test Book getEstimatedTime method.
     */
    @Test
    public void testBookGetEstimatedTime() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        assertEquals("6 hours", book.getEstimatedTime());
    }

    /**
     * Test Book getGenre method.
     */
    @Test
    public void testBookGetGenre() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        assertEquals("Dystopian", book.getGenre());
    }

    /**
     * Test Book getPages method.
     */
    @Test
    public void testBookGetPages() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        assertEquals(328, book.getPages());
    }

    /**
     * Test Book getRating method.
     */
    @Test
    public void testBookGetRating() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        assertEquals(4.5, book.getRating(), 0.001);
    }

    /**
     * Test Book getPagesRead method.
     */
    @Test
    public void testBookGetPagesRead() {
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 100);
        assertEquals(100, book.getPagesRead());
    }

    /**
     * Test get method returns correct book by reference.
     */
    @Test
    public void testGet() {
        Library1L library = new Library1L();
        Library1L.Booky book = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        library.addBook(book);
        assertEquals(book, library.get(0));
    }

    /**
     * Test size method with empty library.
     */
    @Test
    public void testSizeEmpty() {
        Library1L library = new Library1L();
        assertEquals(0, library.size());
    }

    /**
     * Test size method with non-empty library.
     */
    @Test
    public void testSizeNonEmpty() {
        Library1L library = new Library1L();
        Library1L.Booky book1 = new Library1L.Booky("1984", "George Orwell",
                "6 hours", "Dystopian", 328, 4.5, 0);
        Library1L.Booky book2 = new Library1L.Booky("To Kill a Mockingbird",
                "Harper Lee", "7 hours", "Classic", 336, 4.8, 0);
        library.addBook(book1);
        library.addBook(book2);
        assertEquals(2, library.size());
        assertEquals(book1, library.get(0));
        assertEquals(book2, library.get(1));
    }

}
