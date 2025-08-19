/**
 * Custom Array Class that will create and maintain an array that is used to
 * add and remove books in their inverntory as well as display books in their
 * inventory based on which alphabet the title begins with.
 */
public class CustomBookArray {
    //array of books
    private Book[] booksArray;
    //running counter for the size of the array
    private int arraySize;
    //tracker for the numbers of objects stored in booksArray at any one time
    private int arrayCount;
    //maximum size of the array, constant
    private final static int limit = 8;

    /**
     * No parameter constructor that initialises array values
     */
    public CustomBookArray() {
        //start with a size of 2 to store the Book 's objects
        this.arraySize = 2;
        //start with a size of 0 since no books are added yet
        this.arrayCount = 0;
        //array with dynamic size
        this.booksArray = new Book[arraySize];
    }

    /**
     * Adds a book obj to the books array.
     * If the current array is full (arrayCount == arraySize), double the
     * arraySize.
     * It will then add the book if the limit (8) is not reached, else it will
     * print error message.
     *
     * @param book is the book object to be added to the array
     */
    public void add(Book book) {
        if (arrayCount == arraySize) {
            increaseArraySize();
        }
        if (arrayCount < limit) {
            booksArray[arrayCount++] = book;
        } else {
            System.out.println("Error! Cannot add more books. Limit of "
                    + limit + " reached.");
        }
    }

    /**
     * helper function to increase the size of the array by  doubling its
     * size if the array is filled
     */
    private void increaseArraySize() {
        int newSize = Math.min(arraySize * 2, limit);
        Book[] newArray = new Book[newSize];
        for (int i = 0; i < arrayCount; i++) {
            newArray[i] = booksArray[i];
        }
        booksArray = newArray;
        arraySize = newSize;
    }


    /**
     * Remove a book obj to the books array.
     * Shrink array capacity to the next minimum multiple of 2 after each
     * deletion
     *
     * @param title is the title of the book to delete
     */
    public void delete(String title) {
        boolean found = false;
        for (int i = 0; i < arrayCount; i++) {
            if (booksArray[i] != null && booksArray[i].getTitle().equals(title)) {
                System.out.println("Book titled " + title + " was found.");
                System.out.println("Book titled " + title + " was deleted.");
                // Shift elements left to fill the gap
                for (int j = i; j < arrayCount - 1; j++) {
                    booksArray[j] = booksArray[j + 1];
                }
                booksArray[arrayCount - 1] = null;
                arrayCount--;
                found = true;
            }
        }
        if (found) {
            decreaseArraySize();
        } else {
            System.out.println("Book titled '" + title + "' cannot be found.");
        }
    }
    /**
     * helper function to decrease the size. If removing a book will cause the
     * array to have 2 null objects in the array, shrink the array by 2. (i.e
     * 7 books are store in array of size 8, removing 1 book will mean there
     * are 6 books in an array of size 8,  2 null objects, so reduce array
     * size to 6
     */
    private void decreaseArraySize() {
        int newSize = getShrinkSize(arrayCount);
        if (newSize < arraySize) {
            Book[] newArray = new Book[newSize];
            for (int i = 0; i < arrayCount; i++) {
                newArray[i] = booksArray[i];
            }
            booksArray = newArray;
            arraySize = newSize;
        }
    }

    /**
     * helper function to return the new size to shrink the array to
     * @param count is the current number of books in the array
     * @return the new array size
     */
    private int getShrinkSize(int count) {
        if (count <= 2) return 2;
        if (count <= 4) return 4;
        if (count <= 6) return 6;
        return 8; // For 7 or more
    }

    /**
     * Search method which accepts String argument and returns the index of
     * the  book if found, otherwise it returns -1 .
     * @param title of the book that is being searched for
     * @return index if found and -1 if not found
     */
    public int searchBook(String title) {
        for (int i = 0; i < arrayCount; i++) {
            if (booksArray[i] != null && booksArray[i].getTitle().equals(title)) {
                System.out.println("Found - " + booksArray[i]);
                return i;
            }
        }
        System.out.println("Book titled '" + title + "' not found.");
        return -1;
    }

    /**
     * getter function to get the size of the array
     * @return arraySize
     */
    public int getArraySize() {
        return arraySize;
    }

    /**
     * getter function to retrieve details of the book at a specific index
     * @param index is where the details of the book should be
     * @return the details at the index
     */
    public Book getBookAt(int index) {
        if (index >= 0 && index < arrayCount) {
            return booksArray[index];
        }
        return null;
    }
}


