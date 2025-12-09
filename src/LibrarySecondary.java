package components;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 *
 * Abtract Class (Library Secondary) that extends Library.
 */
public abstract class LibrarySecondary implements Library {
    /**
     *
     */
    private List<Book> books = new ArrayList<>();

    /**
     * Get the list of books in the library.
     *
     * @return the list of books
     */
    public List<Book> getBooks() {
        return this.books;
    }

    /**
     * Set the list of books in the library.
     *
     * @param books
     *            the list of books to set
     */
    public void setBooks(List<Book> books) {
        this.books = books;
    }

    /**
     * Provide a ranking of books.
     *
     * @requires library is not empty
     * @ensures books are ranked by user ratings
     * @return a list of books sorted by ranking
     */
    @Override
    public List<Book> bookRanking() {
        List<Book> ranked = new ArrayList<>(this.books);
        ranked.sort(Comparator.comparingDouble(Book::getRating).reversed());
        return ranked;
    }

    /**
     * Estimate the time it takes to read a book.
     *
     * @requires book != null
     * @ensures estimated reading time is calculated based on book length
     * @return estimated time in minutes
     */
    @Override
    public int estimateReadingTime(Book book, int averageReadingSpeed) {
        return book.getPages() / averageReadingSpeed;
    }

    /**
     * Report the progress made in reading a book.
     *
     * @requires book != null
     * @ensures reading progress is updated and reported
     * @return percentage of book read
     */
    @Override
    public double readingProgress(Book book, int totalPages) {
        final int hundred = 100;
        return (double) book.getPagesRead() / book.getPages() * hundred;
    }

    /**
     * List books filtered by genre.
     *
     * @requires library is not empty
     * @ensures books are listed by specified genre
     * @return a list of books in the specified genre
     */
    @Override
    public List<Book> listByGenre() {
        List<Book> genreList = new ArrayList<>();

        for (int i = 0; i < this.books.size(); i++) {
            if (this.books.get(i).getGenre().equals("Horror")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Romance")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Comedy")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Dystopian")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Fantasy")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Classic")) {
                genreList.add(this.books.get(i));
            } else if (this.books.get(i).getGenre().equals("Science Fiction")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Adventure")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Historical")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Fiction")) {
                genreList.add(this.books.get(i));

            } else if (this.books.get(i).getGenre().equals("Classic")) {
                genreList.add(this.books.get(i));

            }
        }
        return genreList;
    }

    /**
     *
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.books.size(); i++) {
            sb.append(this.books.get(i).getTitle()).append("\n");
        }
        return sb.toString();

    }

    /**
     *
     */
    @Override
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof LibrarySecondary)) {
            return false;
        }
        LibrarySecondary other = (LibrarySecondary) obj;
        return this.books.equals(other.books);
    }

}