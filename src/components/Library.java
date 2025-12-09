package components;

import java.util.List;

/**
 * Library.
 */
public interface Library extends LibraryKernel {

    /**
     * Provide a ranking of books.
     *
     * @requires library is not empty
     * @ensures books are ranked by user ratings
     * @return a list of books sorted by ranking
     */
    List<Book> bookRanking();

    /**
     * Estimate the time it takes to read a book.
     *
     * @param book
     * @param averageReadingSpeed
     * @requires book != null
     * @ensures estimated reading time is calculated based on book length
     * @return estimated time in minutes
     */
    int estimateReadingTime(Book book, int averageReadingSpeed);

    /**
     * Report the progress made in reading a book.
     *
     * @param book
     * @param totalPages
     * @requires book != null
     * @ensures reading progress is updated and reported
     * @return percentage of book read
     */
    double readingProgress(Book book, int totalPages);

    /**
     * List books filtered by genre.
     *
     * @requires library is not empty
     * @ensures books are listed by specified genre
     * @return a list of books in the specified genre
     */
    List<Book> listByGenre();

}
