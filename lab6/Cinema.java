import java.util.Scanner;

public class Cinema {

    private static final int NUM_HALLS = 5;
    private static final int NUM_ROWS = 10;
    private static final int NUM_SEATS_PER_ROW = 20;

    private static int[][][] seats = new int[NUM_HALLS][NUM_ROWS][NUM_SEATS_PER_ROW];

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Ініціалізація масиву
        for (int hall = 0; hall < NUM_HALLS; hall++) {
            for (int row = 0; row < NUM_ROWS; row++) {
                for (int seat = 0; seat < NUM_SEATS_PER_ROW; seat++) {
                    seats[hall][row][seat] = 0; // вільне місце
                }
            }
        }

        while (true) {
            System.out.println("\nМеню:");
            System.out.println("1. Забронювати місце");
            System.out.println("2. Скасувати бронювання");
            System.out.println("3. Перевірити наявність місць");
            System.out.println("4. Друк схеми розміщення місць");
            System.out.println("5. Знайти найкращі доступні місця (бонус)");
            System.out.println
            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    bookSeats(scanner);
                    break;
                case 2:
                    cancelBooking(scanner);
                    break;
                case 3:
                    checkAvailability(scanner);
                    break;
                case 4:
                    printSeatingArrangement(scanner);
                    break;
                case 5:
                    findBestAvailable(scanner);
                    break;
                case 6:
                    autoBook(scanner);
                    break;
                default:
                    System.out.println("Невідома дія.");
            }
        }
    }
}
