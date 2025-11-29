import java.util.List;

/**
 * Abtract Class (Library Secondary) that extends Library
 */
public interface LibrarySecondary extends Library {

    /**
     * Provide a ranking of books.
     *
     * @requires library is not empty
     * @ensures books are ranked by user ratings
     * @returns a list of books sorted by ranking
     */
    public List<Book> bookRanking() {
        List<Book> ranked = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            ranked.add(books.getRating(i));
        }

        ranked.sort(Comparator.comparingDouble(Book::getRating).reversed());
        return ranked;
    }

    /**
     * Estimate the time it takes to read a book.
     *
     * @requires book != null
     * @ensures estimated reading time is calculated based on book length
     * @returns estimated time in minutes
     */
    void estimateReadingTime(Book book, int averageReadingSpeed) {
        return book.getPages() / averageReadingSpeed;
    }

    /**
     * Report the progress made in reading a book.
     *
     * @requires book != null
     * @ensures reading progress is updated and reported
     * @returns percentage of book read
     */
    void readingProgress(Book book) {
        return (double) book.getPagesRead() / book.getPageCount() * 100;
    }

    /**
     * List books filtered by genre.
     *
     * @requires library is not empty
     * @ensures books are listed by specified genre
     * @returns a list of books in the specified genre
     */
    void listByGenre() {
        List<Book> genreList = new ArrayList<>();

        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getGenre().equals("Horror")) {
                genreList.add(books.getTitle(i));

            } else if (books.get(i).getGenre().equals("Romance")) {
                genreList.add(books.getTitle(i));

            } else if (books.get(i).getGenre().equals("Comedy")) {
                genreList.add(books.getTitle(i));

            }
        }
        return genreList;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Library: ");

        for (int i = 0; i < books.size(); i++) {
            sb.append(books.getTitle(i).toString()).append("\n");
        }

        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {
        boolean result = false;

        for (int i = 0; i < books.size(); i++) {
            if (this.books.getTitle(i).equals(((Library) obj).books.getTitle(i))) {
                result = true;
            } else {
                result = false;
            }
        }

        return result;
    }

}