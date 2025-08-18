package Book;

public class Book {
    private String title;
    private String author;
    private String page;

    public Book(String title, String author, String page){
        this.title = title;
        this.author = author;
        this.page = page;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPage() {
        return page;
    }

    public String toString() {
        return "Title: " + getTitle() + " Author: " + getAuthor() + " Page: " + getPage();
    }

}
