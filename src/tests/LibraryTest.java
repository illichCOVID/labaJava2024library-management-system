import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LibraryTest {
    private Library library;

    @BeforeEach
    public void setUp() {
        library = new Library();
    }

    @Test
    public void testAddBook() {
        Book book = new Book("Test Book", "Test Author", "123456789", 2021);
        library.addBook(book);
        assertEquals(1, library.getBooks().size());
    }

    @Test
    public void testFindBookByTitle() {
        Book book = new Book("Test Book", "Test Author", "123456789", 2021);
        library.addBook(book);
        Book foundBook = library.findBookByTitle("Test Book");
        assertNotNull(foundBook);
        assertEquals("Test Author", foundBook.getAuthor());
    }

    @Test
    public void testRemoveBookByIsbn() {
        Book book = new Book("Test Book", "Test Author", "123456789", 2021);
        library.addBook(book);
        boolean isRemoved = library.removeBookByIsbn("123456789");
        assertTrue(isRemoved);
        assertEquals(0, library.getBooks().size());
    }

    @Test
    public void testRemoveNonExistentBook() {
        boolean isRemoved = library.removeBookByIsbn("987654321");
        assertFalse(isRemoved);
    }

    @Test
    public void testFindNonExistentBook() {
        Book foundBook = library.findBookByTitle("Non Existent Book");
        assertNull(foundBook);
    }
}
