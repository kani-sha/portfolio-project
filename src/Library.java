import components.queue.Queue1L;

/**
 * Represents a simple library component.
 *
 * @param <T>
 *            the type of elements in this library
 */
public interface Library<T> extends Queue1L<T> {

    /**
     * Private members ----------------------------------------
     */
    private Queue1L<T> books;
    private String author;
    private int estimatedTime;
    private String reflection;

    /*
     * Constructor --------------------------------------------
     */

    /**
     * No-argument constructor.
     */
    private void createNewLibrary() {
        this.books = new Queue1L<T>();

    }

    /*
     * Kernel methods -----------------------------------------
     */

    /**
    * Adds a book to the library.
    *
    * @param book the book being added to the library
    */
    public void addBook(T book) {
        this.books.enqueue(book);
    }

    /**
    * Removes a book from the library.
    *
    */
    public void removeBook() {
        String book = "";
        book = this.books.dequeue();
        return book;
    }

    /**
    * Finds a book in the library.
    *
    * @param book the book being searched for in the library
    */
    public void findBook(T book) {
        Queue1L<T> tempQueue = new Queue1L<T>();
        boolean found = false;

        while (!this.books.isEmpty()) {
            T currentBook = this.books.dequeue();
            if (currentBook.equals(book)) {
                found = true;
            }
            tempQueue.enqueue(currentBook);
        }
    }

    /*
     * Secondary methods ---------------------------------------
     */

    /**
    * Finds the author of the book.
    *
    */
    public void author() {
        return this.author;
    }

    /**
    * Gets the estimated time to complete the book.
    */
    public void estimatedTime() {
        return this.estimatedTime;
    }

    /**
    * Allows the reader to write a reflection on the book.
    */
    public void reflection() {
        Scanner input = new Scanner(System.in);
        System.out.println("Write your reflection here: ");
        String ref = input.nextLine();
        System.out.println("Save yout reflection? (Y/N)");
        String ans = input.nextLine();

        if (ans.equals("Y")) {
            this.reflection = System.in;
        } else {
            System.out.println("Reflection not saved.");
        }
    }

    /**
     * Main method for the Library interface.
     *
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Welcome to the Library Component!");

    }
}