import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Library library = new Library();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Show All Books");
            System.out.println("3. Find Book by Title");
            System.out.println("4. Remove Book by ISBN");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.println("Enter title:");
                    String title = scanner.nextLine();
                    System.out.println("Enter author:");
                    String author = scanner.nextLine();
                    System.out.println("Enter ISBN:");
                    String isbn = scanner.nextLine();
                    System.out.println("Enter publication year:");
                    int year = scanner.nextInt();
                    scanner.nextLine(); // Consume newline

                    Book newBook = new Book(title, author, isbn, year);
                    library.addBook(newBook);
                    break;
                case 2:
                    library.showAllBooks();
                    break;
                case 3:
                    System.out.println("Enter title:");
                    String searchTitle = scanner.nextLine();
                    Book foundBook = library.findBookByTitle(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook);
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter ISBN:");
                    String searchIsbn = scanner.nextLine();
                    boolean isRemoved = library.removeBookByIsbn(searchIsbn);
                    if (isRemoved) {
                        System.out.println("Book removed.");
                    } else {
                        System.out.println("Book not found.");
                    }
                    break;
                case 5:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
