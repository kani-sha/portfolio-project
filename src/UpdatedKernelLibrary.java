/**
 * Library kernel component.
 */
public interface LibraryKernel extends Standard<Library> {

    /**
     * Represents a book object that can be stored in the library.
     */
    class Book {
        String title;
        String author;
        String estimatedTime;
        String genre;
        int pages;
        double rating;
        int pagesRead;

        /**
         * Constructs a Book with the data provided by user.
         *
         * @param title
         *            the book title
         * @param author
         *            the book author
         * @param estimatedTime
         *            the estimated reading time
         * @param genre
         *            the book genre
         * @param pages
         *            the total number of pages
         * @param rating
         *            the book rating
         * @param pagesRead
         *            the number of pages already read
         */
        public Book(String title, String author, String estimatedTime,
                String genre, int pages, double rating, int pagesRead) {
            this.title = title;
            this.author = author;
            this.estimatedTime = estimatedTime;
            this.genre = genre;
            this.pages = pages;
            this.rating = rating;
            this.pagesRead = 0;
        }

    }

    /**
     * Adds a book to the library.
     *
     * @param book
     *            the book to add
     * @updates this
     * @requires book != null
     * @ensures this = #this + {book}
     */
    void addBook(Book book);

    /**
     * Removes a book from the library.
     *
     * @param book
     *            the book to remove
     * @updates this
     * @requires book != null and book is in this
     * @ensures this = #this - {book}
     */
    void removeBook(Book book);

    /**
     * Finds a book by title.
     *
     * @param title
     *            the title to search for
     * @return true if a book with the given title is found, false otherwise
     * @ensures findBook = (exists book in this & book.title = title)
     */
    boolean findBook(String title);

    // Additional methods needed for LibrarySecondary
    public String getTitle() {
            return this.title;
    }

    public String getAuthor() {
        return this.author;
    }

    public String getGenre() {
        return this.genre;
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

    // Finds book by index
    Book get(int i) {
        return books.get(i);
    }

    // Returns size of library
    int size() {
        return books.size();
    }
}
