package HotelManagementSystemLLD;

public class Room {
    private final String id;
    private RoomType type;
    private RoomStatus status;
    private double price;

    public Room(String id, RoomType type, double price) {
        this.id=id;
        this.type=type;
        this.price=price;
        this.status=RoomStatus.AVAILABLE;
    }

    public synchronized void book() {
        if (status==RoomStatus.AVAILABLE)
            status=RoomStatus.BOOKED;
        else
            throw new IllegalStateException("Room is not available for booking.");
    }

    public synchronized void checkIn() {
        if (status==RoomStatus.BOOKED)
            status=RoomStatus.OCCUPIED;
        else
            throw new IllegalStateException("Room is not booked.");
    }

    public synchronized void checkOut() {
        if (status==RoomStatus.OCCUPIED)
            status=RoomStatus.AVAILABLE;
        else
            throw new IllegalStateException("Room is not occupied");
    }

    public String getId() {
        return id;
    }

    public RoomType getType() {
        return type;
    }

    public void setType(RoomType type) {
        this.type = type;
    }

    public RoomStatus getStatus() {
        return status;
    }

    public void setStatus(RoomStatus status) {
        this.status = status;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
