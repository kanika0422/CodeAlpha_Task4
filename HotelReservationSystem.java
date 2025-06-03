/*
Build a hotel reservation system where users can
search for available rooms, make reservations, and view
booking details. Include features like room
categorization and payment processing.
*/



import java.util.*;

public class HotelReservationSystem {
    static List<Room> rooms = new ArrayList<>();
    static List<Reservation> reservations = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeRooms();
        int choice;
        do {
            System.out.println("\n=== Hotel Reservation System ===");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View My Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt(); scanner.nextLine();

            switch (choice) {
                case 1 -> showAvailableRooms();
                case 2 -> makeReservation();
                case 3 -> showReservations();
                case 4 -> System.out.println("Thank you for using our system.");
                default -> System.out.println("Invalid choice.");
            }
        } while (choice != 4);
    }

    static void initializeRooms() {
        rooms.add(new Room(101, "Single", 50));
        rooms.add(new Room(102, "Double", 75));
        rooms.add(new Room(103, "Suite", 120));
        rooms.add(new Room(104, "Single", 55));
        rooms.add(new Room(105, "Double", 80));
    }

    static void showAvailableRooms() {
        System.out.println("\nAvailable Rooms:");
        for (Room room : rooms) {
            if (!room.isBooked)
                System.out.println(room);
        }
    }

    static void makeReservation() {
        showAvailableRooms();
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter room number to book: ");
        int number = scanner.nextInt(); scanner.nextLine();

        Room selected = null;
        for (Room room : rooms) {
            if (room.number == number && !room.isBooked) {
                selected = room;
                break;
            }
        }

        if (selected != null) {
            System.out.println("Room selected: " + selected);
            System.out.println("Processing payment of $" + selected.price + "...");
            System.out.println("Payment successful!");

            Reservation reservation = new Reservation(name, selected);
            reservations.add(reservation);
            System.out.println("Booking confirmed!");
        } else {
            System.out.println("Room not available or invalid number.");
        }
    }

    static void showReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No reservations yet.");
            return;
        }

        System.out.println("\nAll Reservations:");
        for (Reservation res : reservations)
            System.out.println(res);
    }
}



