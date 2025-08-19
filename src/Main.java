public class Main {
    public static void main(String[] args) {
        BookManagement manager = new BookManagement();

        // Sample input 1
        Book book1 = new Book("Apple Invasion", "Tim Hill", 200);
        Book book2 = new Book("Bambi", "Felix Salten", 150);
        // Sample input 2
        Book book3 = new Book("animal farm", "John Doe", 100);
        Book book4 = new Book("batman returns", "Alfred Hugh", 350);
        // Sample input 3 — simulate a search
        Book book5 = new Book("Apple Invasion 1", "Tim Hill", 200);
        Book book6 = new Book("Apple Invasion 5", "Tim Hill", 200);
        Book book7 = new Book("Apple Invasion 7", "Tim Hill", 200);
        Book book8 = new Book("Apple Invasion 8", "Tim Hill", 200);
        Book book9 = new Book("Apple Invasion 9", "Tim Hill", 200);
        Book book10 = new  Book("Apple Invasion 10", "Tim Hill", 200);
        Book book11 = new Book("Apple Invasion 11", "Tim Hill", 200);
        Book book12 = new Book("cucumber Invasion", "Tim Hill", 200);
        Book book13 = new Book("durian Invasion", "Tim Hill", 200);

        manager.add(book1);
        manager.add(book2);

        manager.display('a'); // Expected: A: [Apple Invasion, null]
        manager.display('B'); // Expected: B: [Bambi, null]

        manager.add(book3);
        manager.add(book4);

        manager.display('a'); // Expected: A: [Apple Invasion, animal farm]
        manager.display('B'); // Expected: B: [Bambi, batman returns]

        manager.add(book5);
        manager.add(book6);
        manager.add(book7);

        manager.display('A'); // Expected: A: [Apple Invasion, animal farm, Apple Invasion 1, Apple Invasion 5, Apple Invasion 7]

        manager.searchBook("Apple Invasion"); // Expected: Found - Title: Apple Invasion 1 Author: Tim Hill Page: 200
        manager.searchBook("Apple Invasion 15");


        //manager.delete("Apple Invasion 1");
        manager.display('A');
        manager.getArraySize('a');
        manager.display('b');
        manager.getArraySize('B');

        manager.add(book8);
        manager.add(book9);
        manager.add(book10);
        manager.display('A');
        manager.getArraySize('a');

        manager.add(book11);
        manager.display('A');
        manager.getArraySize('a');

        manager.add(book12);
        manager.add(book13);

//        manager.delete("Bambi");
//        manager.display('b');
//        manager.getArraySize('B');
//
        manager.getArraySize('a');
        manager.delete("Apple Invasion 10");
        manager.display('a');
        manager.getArraySize('a');
        manager.delete("Apple Invasion 9");
        manager.display('a');
        manager.getArraySize('a');

    }
}