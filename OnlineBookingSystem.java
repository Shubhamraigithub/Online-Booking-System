import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Room {
    private int roomNumber;
    private boolean isBooked;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
        this.isBooked = false;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void book() {
        isBooked = true;
    }

    public void cancelBooking() {
        isBooked = false;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + ", Status: " + (isBooked ? "Booked" : "Available");
    }
}

class Hotel {
    private List<Room> rooms = new ArrayList<>();

    public Hotel(int roomCount) {
        for (int i = 1; i <= roomCount; i++) {
            rooms.add(new Room(i));
        }
    }

    public Room getRoom(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void displayRooms() {
        System.out.println("List of Rooms:");
        for (Room room : rooms) {
            System.out.println(room);
        }
    }
}

public class OnlineBookingSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of rooms in the hotel: ");
        int roomCount = scanner.nextInt();
        Hotel hotel = new Hotel(roomCount);

        while (true) {
            System.out.println("\nOnline Booking System Menu:");
            System.out.println("1. Book a Room");
            System.out.println("2. Cancel Booking");
            System.out.println("3. View Room Availability");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the room number to book: ");
                    int roomNumberToBook = scanner.nextInt();
                    Room roomToBook = hotel.getRoom(roomNumberToBook);

                    if (roomToBook != null && !roomToBook.isBooked()) {
                        roomToBook.book();
                        System.out.println("Room booked successfully.");
                    } else {
                        System.out.println("Room is not available for booking.");
                    }
                    break;
                case 2:
                    System.out.print("Enter the room number to cancel the booking: ");
                    int roomNumberToCancel = scanner.nextInt();
                    Room roomToCancel = hotel.getRoom(roomNumberToCancel);

                    if (roomToCancel != null && roomToCancel.isBooked()) {
                        roomToCancel.cancelBooking();
                        System.out.println("Booking canceled successfully.");
                    } else {
                        System.out.println("Room is not booked or does not exist.");
                    }
                    break;
                case 3:
                    hotel.displayRooms();
                    break;
                case 4:
                    System.out.println("Exiting Online Booking System.");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }
}
