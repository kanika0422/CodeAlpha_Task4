public class Room {
    public int number;
    public String type; // Single, Double, Suite
    public double price;
    public boolean isBooked;

    public Room(int number, String type, double price) {
        this.number = number;
        this.type = type;
        this.price = price;
        this.isBooked = false;
    }

    @Override
    public String toString() {
        return "Room " + number + " (" + type + ") - $" + price + (isBooked ? " [Booked]" : " [Available]");
    }
}
