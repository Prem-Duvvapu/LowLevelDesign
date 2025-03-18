package BookMyShow;
import java.util.*;

public class Booking {
    int id;
    Show show;
    List<Seat> bookedSeats;
    Payment payment;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public Show getShow() {
        return show;
    }

    public void setShow(Show show) {
        this.show=show;
    }

    public List<Seat> getBookedSeats() {
        return bookedSeats;
    }

    public void setBookedSeats(List<Seat> bookedSeats) {
        this.bookedSeats=bookedSeats;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment=payment;
    }
}
