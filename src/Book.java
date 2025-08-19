/**
 * Book Class that contains the title, author and page number of a book.
 */
public class Book {
    private String title;
    private String author;
    private int page;

    /**
     * Constructor that initializes all 3 fields with external data within
     * @param title is the title of the book in String format
     * @param author is the name of the author in String format
     * @param page is the number of pages in the book in int format
     */
    public Book(String title, String author, int page){
        this.title = title;
        this.author = author;
        this.page = page;
    }

    /**
     * Getter function to get title of book
     * @return title of book
     */
    public String getTitle() {
        return title;
    }

    /**
     * Getter function to get name of author
     * @return author's name
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Getter function to get the number of pages the book has
     * @return number of pages
     */
    public int getPage() {
        return page;
    }

    /**
     * Each Book object must be printable with the following format:
     * Title: Effective Java Author: Joshua Bloch Page: 375
     * @return Title: _______ Author: _______  Page: _______
     */
    public String toString() {
        return "Title: " + getTitle() + " Author: " + getAuthor() + " Page: " + getPage();
    }
}
