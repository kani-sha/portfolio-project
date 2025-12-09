package components;

/**
 * Library Kernel Implementation.
 *
 * @convention this.getBooks() != null
 * @correspondence the Book representation is a List of Books
 */
public class Library1L extends LibrarySecondary {
    /**
     * Represents a book object that can be stored in the library.
     */
    public static class Booky implements Book {
        /**
         * The title of the book.
         */
        private String title;
        /**
         * The author of the book.
         */
        private String author;
        /**
         * The estimated reading time for the book.
         */
        private String estimatedTime;
        /**
         * The genre of the book.
         */
        private String genre;
        /**
         * The total number of pages in the book.
         */
        private int pages;
        /**
         * The rating of the book.
         */
        private double rating;
        /**
         * The number of pages already read.
         */
        private int pagesRead;

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
        public Booky(String title, String author, String estimatedTime,
                String genre, int pages, double rating, int pagesRead) {
            this.title = title;
            this.author = author;
            this.estimatedTime = estimatedTime;
            this.genre = genre;
            this.pages = pages;
            this.rating = rating;
            this.pagesRead = pagesRead;
        }

        /**
         * Returns the title of the book.
         *
         * @return the book title
         */
        @Override
        public String getTitle() {
            return this.title;
        }

        /**
         * Returns the author of the book.
         *
         * @return the book author
         */
        @Override
        public String getAuthor() {
            return this.author;
        }

        /**
         * Returns the estimated reading time of the book.
         *
         * @return the estimated reading time
         */
        @Override
        public String getEstimatedTime() {
            return this.estimatedTime;
        }

        /**
         * Returns the genre of the book.
         *
         * @return the book genre
         */
        @Override
        public String getGenre() {
            return this.genre;
        }

        /**
         * Returns the total number of pages in the book.
         *
         * @return the total number of pages
         */
        @Override
        public int getPages() {
            return this.pages;
        }

        /**
         * Returns the rating of the book.
         *
         * @return the book rating
         */
        @Override
        public double getRating() {
            return this.rating;
        }

        /**
         * Returns the number of pages already read.
         *
         * @return the number of pages read
         */
        @Override
        public int getPagesRead() {
            return this.pagesRead;
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
    @Override
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null");
        }
        this.getBooks().add(book);
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
    @Override
    public void removeBook(Book book) {
        if (book == null || !this.getBooks().contains(book)) {
            throw new IllegalArgumentException(
                    "Book cannot be found in the library");
        }
        this.getBooks().remove(book);
    }

    /**
     * Finds a book by title.
     *
     * @param title
     *            the title to search for
     * @return true if a book with the given title is found, false otherwise
     * @ensures findBook = (exists book in this & book.title = title)
     */
    @Override
    public boolean findBook(String title) {
        for (int i = 0; i < this.getBooks().size(); i++) {
            if (this.getBooks().get(i).getTitle().equals(title)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Gets the index book in the library.
     *
     * @param i
     * @return the index of the book in the library
     */
    @Override
    public Book get(int i) {
        return this.getBooks().get(i);
    }

    /**
     * Gets the size of the library.
     *
     * @return the size of the library
     */
    @Override
    public int size() {
        return this.getBooks().size();
    }

}
