package BookMyShow;

public class Seat {
    int id;
    int rowNumber;
    int price;
    SeatCategory seatCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber=rowNumber;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price=price;
    }

    public SeatCategory getSeatCategory() {
        return seatCategory;
    }

    public void setSeatCategory(SeatCategory seatCategory) {
        this.seatCategory=seatCategory;
    }
}
