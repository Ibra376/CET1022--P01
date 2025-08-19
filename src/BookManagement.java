/**
 * Book management class that creates the customBookArrays and calls the
 * respective methods to manage the inventories
 */
public class BookManagement{
    private CustomBookArray arrayA;
    private CustomBookArray arrayB;

    /**
     * initialise the 2 arrays
     */
    public BookManagement() {
        this.arrayA = new CustomBookArray();
        this.arrayB = new CustomBookArray();
    }

    /**
     * checks what the first letter of the title is. If it starts with A or a
     * add to arrayA, if it starts with B or b add to arrayB, else print
     * error message
     * @param book is the book object to be added
     */
    public void add(Book book) {
        char firstChar = book.getTitle().charAt(0);
        if (firstChar == 'A' || firstChar == 'a') {
            arrayA.add(book);
        } else if (firstChar == 'B'|| firstChar == 'b') {
            arrayB.add(book);
        } else {
            System.out.println("Unsupported title prefix (Should be A or B): " + firstChar);
        }
    }

    /**
     * checks the first letter of the title of the book. if it is A or a
     * then delete from arrayA, if it is B or b delete from arrayB else print
     * an error message
     * @param title is the title of the book to be removed
     */
    public void delete(String title) {
        char firstChar = title.charAt(0);
        if (firstChar == 'A'|| firstChar == 'a') {
            arrayA.delete(title);
        } else if (firstChar == 'B'|| firstChar == 'b') {
            arrayB.delete(title);
        } else {
            System.out.println("Unsupported title prefix (Should be A or B): " + firstChar);
        }
    }

    /**
     * method to print both arrays
     */
    public void display() {
        display('A');
        display('B');
    }

    /**
     *method to print either arrayA or arrayB. switch case used to decide
     * which array to display
     * @param prefix is the first letter of the titles in the array
     */
    public void display(char prefix) {
        CustomBookArray targetArray = null;
        String label = "";

        switch (Character.toUpperCase(prefix)) {
            case 'A':
                targetArray = arrayA;
                label = "A";
                break;
            case 'B':
                targetArray = arrayB;
                label = "B";
                break;
            default:
                System.out.println("Unsupported prefix: " + prefix);
                return;
        }

        System.out.print(label + ": [");
        for (int i = 0; i < targetArray.getArraySize(); i++) {
            if (i > 0) System.out.print(", ");

            Book book = targetArray.getBookAt(i);
            if (book != null) {
                System.out.print(book.getTitle());
            } else {
                System.out.print("null");
            }
        }
        System.out.println("]");
    }

    /**
     * method to decide which array to search. if first letter is A or a,
     * search arrayA if its B or b search arrayB
     * @param title of the book to be searched
     */
    public void searchBook(String title) {
        char firstChar = title.charAt(0);
        int index = -1;

        if (firstChar == 'A'|| firstChar == 'a') {
            index = arrayA.searchBook(title);
        } else if (firstChar == 'B'|| firstChar == 'b') {
            index = arrayB.searchBook(title);
        }
    }

    /**
     * method to return the size of a chosen array. same method of deciding
     * the array as above
     * @param prefix is the first letter of the titles in the array
     * @return the size of the desired array
     */
    public int getArraySize(char prefix) {
        if (prefix == 'A' || prefix == 'a') {
            //System.out.println("Array size A: " +  arrayA.getArraySize());
            return arrayA.getArraySize();
        }
        if (prefix == 'B' || prefix == 'b') {
            //System.out.println("Array size B: " +  arrayB.getArraySize());
            return arrayB.getArraySize();
        }
        return -1;
    }
}