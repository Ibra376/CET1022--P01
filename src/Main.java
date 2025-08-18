import Book.Book;
import CustomBookArray.CustomBookArray;

public class Main {
    public static void main(String[] args) {
        // Create a Book instance
        Book bookA = new Book("Effective Java", "Joshua Bloch", "375");
        System.out.println("Single Book:");
        System.out.println(bookA);

        // Create a CustomBookArray and add books
        CustomBookArray shelf = new CustomBookArray();
        shelf.add(bookA);
        shelf.add(new Book("Clean Code", "Robert C. Martin", "464"));
        shelf.add(new Book("Refactoring", "Martin Fowler", "431"));
        shelf.add(new Book("Design Patterns", "Erich Gamma", "395"));

        // Print all books
        System.out.println("\nBooks on Shelf:");
        printBooks(shelf);

        // Delete a book
        System.out.println("\nDeleting 'Clean Code'...");
        shelf.delete("Clean Code");

        // Print updated list
        System.out.println("\nAfter Deletion:");
        printBooks(shelf);

        // Show current array size
        System.out.println("\nCurrent array size: " + shelf.getArraySize());
    }

    // ✅ Corrected helper method to print only stored books
    public static void printBooks(CustomBookArray shelf) {
        for (int i = 0; i < shelf.getArraySize(); i++) {
            Book book = shelf.getBookAt(i);
            if (book != null) {
                System.out.println(book);
            }
        }
    }
}