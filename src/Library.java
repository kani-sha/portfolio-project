/**
 * {@code LibraryKernel} enhanced with secondary methods.
 */
public interface Library extends LibraryKernel {

    /**
     * Provide a ranking of books.
     *
     * @requires library is not empty
     * @ensures books are ranked by user ratings
     * @returns a list of books sorted by ranking
     */
    void bookRanking();

    /**
     * Estimate the time it takes to read a book.
     *
     * @requires book != null
     * @ensures estimated reading time is calculated based on book length
     * @returns estimated time in minutes
     */
    void estimateReadingTime();

    /**
     * Report the progress made in reading a book.
     *
     * @requires book != null
     * @ensures reading progress is updated and reported
     * @returns percentage of book read
     */
    void readingProgress();

    /**
     * List books filtered by genre.
     *
     * @requires library is not empty
     * @ensures books are listed by specified genre
     * @returns a list of books in the specified genre
     */
    void listByGenre();

}
