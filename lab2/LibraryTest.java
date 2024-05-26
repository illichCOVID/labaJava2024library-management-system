package tests;

import items.Book;
import items.DVD;
import items.Item;
import library.Library;
import patrons.Patron;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {
    private Library library;
    private Book book;
    private DVD dvd;
    private Patron patron;

    @BeforeEach
    public void setUp() {
        library = new Library();
        book = new Book("1984", "ISBN987654", "George Orwell");
        dvd = new DVD("The Matrix", "DVD987654", 136);
        patron = new Patron("Alice", "PATRON456");
        library.add(book);
        library.add(dvd);
        library.registerPatron(patron);
    }

    @Test
    public void testAddAndRemoveItem() {
        Book newBook = new Book("Brave New World", "ISBN112233", "Aldous Huxley");
        library.add(newBook);
        assertTrue(library.listAvailable().contains(newBook));

        library.remove(newBook);
        assertFalse(library.listAvailable().contains(newBook));
    }

    @Test
    public void testLendAndReturnItem() {
        library.lendItem(patron, book);
        assertTrue(book.isBorrowed());
        assertTrue(patron.getBorrowedItems().contains(book));

        library.returnItem(patron, book);
        assertFalse(book.isBorrowed());
        assertFalse(patron.getBorrowedItems().contains(book));
    }

    @Test
    public void testListAvailableAndBorrowedItems() {
        library.lendItem(patron, book);
        List<Item> availableItems = library.listAvailable();
        List<Item> borrowedItems = library.listBorrowed();

        assertTrue(availableItems.contains(dvd));
        assertFalse(availableItems.contains(book));

        assertTrue(borrowedItems.contains(book));
        assertFalse(borrowedItems.contains(dvd));
    }
}
