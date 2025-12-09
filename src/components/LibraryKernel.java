package components;

/**
 * Library Kernel.
 */
public interface LibraryKernel {
    /**
     * Represents a book object that can be stored in the library.
     */
    interface Book {

        /**
         * Gets the title of the book.
         *
         * @return the title of the book
         */
        String getTitle();

        /**
         * Gets the author of the book.
         *
         * @return the author of the book
         */
        String getAuthor();

        /**
         * Gets the estimated reading time of the book.
         *
         * @return the estimated reading time
         */
        public abstract String getEstimatedTime();

        /**
         * Gets the genre of the book.
         *
         * @return the genre of the book
         */
        public abstract String getGenre();

        /**
         * Gets the total number of pages in the book.
         *
         * @return the total number of pages
         */
        public abstract int getPages();

        /**
         * Gets the rating of the book.
         *
         * @return the rating of the book
         */
        public abstract double getRating();

        /**
         * Gets the number of pages already read.
         *
         * @return the number of pages read
         */
        public abstract int getPagesRead();

    }

    /**
     * Adds a book to the library.
     *
     * @param book
     *            the book to add
     * @updates this
     * @requires book != null
     * @ensures this = #this + {book}
     *
     *
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

    /**
     *
     * @return book
     * @param i
     */
    Book get(int i);

    /**
     *
     * @return size
     */
    int size();

}
