package CustomBookArray;

import Book.Book;

public class CustomBookArray {
    private Book[] booksArray;
    //running counter for the size of the array
    private int arraySize;
    //tracker for the numbers of objects stored in the booksArray at any point
    //in time
    private int arrayCount;
    //maximum size of the array, constant
    private final static int limit = 8;

    public CustomBookArray() {
        this.arraySize = 2;
        this.arrayCount = 0;
        this.booksArray = new Book[arraySize];
    }

    public void add(Book book) {
        if (arrayCount == arraySize) {
            reSizeArray();
        }
        if (arrayCount < limit) {
            booksArray[arrayCount++] = book;
        } else {
            System.out.println("Error! Cannot add more books. Limit of "
                    + limit + " reached.");
        }
    }

    public void delete(String title) {
        boolean found = false;
        for (int i = 0; i < arrayCount; i++) {
            if (booksArray[i] != null && booksArray[i].getTitle().equals(title)) {
                found = true;
                // Shift elements left to fill the gap
                for (int j = i; j < arrayCount - 1; j++) {
                    booksArray[j] = booksArray[j + 1];
                }
                booksArray[arrayCount - 1] = null;
                arrayCount--;
                break;
            }
        }
        if (!found) {
            System.out.println("Book titled '" + title + "' not found.");
        }
    }

    public void reSizeArray() {
        int newSize = Math.min(arraySize + 2, limit);
        Book[] newArray = new Book[newSize];
        for (int i = 0; i < arrayCount; i++) {
            newArray[i] = booksArray[i];
        }
        booksArray = newArray;
        arraySize = newSize;
    }

    public void searchBook(String title) {
        for (int i = 0; i < arrayCount; i++) {
            if (booksArray[i] != null && booksArray[i].getTitle().equals(title)) {
                System.out.println("Found: " + booksArray[i]);
                return;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
    }
    public int getArraySize() {
        return arraySize;
    }

    public Book getBookAt(int index) {
        if (index >= 0 && index < arrayCount) {
            return booksArray[index];
        }
        return null;
    }

}


