/**
 * Library Kernel Component Implementation.
 */
public interface Library1L extends LibrarySecondary {

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
     * Gets the title of the book.
     *      @returns the title of the book
     */
    public String getTitle() {
            return this.title;
    }

    /**
     * Gets the author of the book.
     *      @returns the author of the book
     */
    public String getAuthor() {
        return this.author;
    }

    /**
     * Gets the genre of the book.
     *      @returns the genre of the book
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Gets the number of pages in the book.
     *      @returns the number of pages in the book
     */
    public int getPages() {
        return this.pages;
    }

    /**
     * Gets the rating of the book.
     *      @returns the rating of the book
     */
    public double getRating() {
        return this.rating;
    }

    /**
     * Gets the number of pages read in the book.
     *      @returns the number of pages read in the book
     */
    public int getPagesRead() {
        return this.pagesRead;
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
    void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        books.add(book);
    }

    /**
     * Removes a book from the library.
     *
     * @param book
     *            the book to remove
     * @updates this
     * @requires book != null and book is in this
     * @ensures this = #this - {book}
     */
    void removeBook(Book book){
        if (book == null || !books.contains(book)) {
            throw new IllegalArgumentException("Book cannot be found in the library");
        }
        books.remove(book);
    }

    /**
     * Finds a book by title.
     *
     * @param title
     *            the title to search for
     * @return true if a book with the given title is found, false otherwise
     * @ensures findBook = (exists book in this & book.title = title)
     */
    boolean findBook(String title){
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the index book in the library.
     * @param i
     * @return the index of the book in the library
     */
    Book get(int i) {
        return books.get(i);
    }

    /**
     * Gets the size of the library.
     * @return the size of the library
     */
    int size() {
        return books.size();
    }

}
