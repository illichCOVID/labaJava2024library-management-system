package library;

import items.Book;
import items.DVD;
import patrons.Patron;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();

        // Create items
        Book book1 = new Book("The Great Gatsby", "ISBN123456", "F. Scott Fitzgerald");
        DVD dvd1 = new DVD("Inception", "DVD123456", 148);

        // Add items to library
        library.add(book1);
        library.add(dvd1);

        // Register a patron
        Patron patron1 = new Patron("John Doe", "PATRON123");

        library.registerPatron(patron1);

        // Lend item to patron
        library.lendItem(patron1, book1);

        // List available and borrowed items
        System.out.println("Available items:");
        for (Item item : library.listAvailable()) {
            System.out.println(item.getTitle());
        }

        System.out.println("\nBorrowed items:");
        for (Item item : library.listBorrowed()) {
            System.out.println(item.getTitle());
        }

        // Return item
        library.returnItem(patron1, book1);

        // List available and borrowed items again
        System.out.println("\nAvailable items after returning:");
        for (Item item : library.listAvailable()) {
            System.out.println(item.getTitle());
        }

        System.out.println("\nBorrowed items after returning:");
        for (Item item : library.listBorrowed()) {
            System.out.println(item.getTitle());
        }
    }
}
