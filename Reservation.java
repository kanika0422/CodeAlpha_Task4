public class Reservation {
    public String guestName;
    public Room room;

    public Reservation(String guestName, Room room) {
        this.guestName = guestName;
        this.room = room;
        this.room.isBooked = true;
    }

    @Override
    public String toString() {
        return "Reservation for " + guestName + " - " + room.toString();
    }
}

