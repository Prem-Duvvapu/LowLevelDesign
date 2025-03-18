package BookMyShow;
import java.util.*;

public class Booking {
    int id;
    Show show;
    List<Integer> seatIds;
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

    public List<Integer> getSeatIds() {
        return seatIds;
    }

    public void setSeatIds(List<Integer> seatIds) {
        this.seatIds=seatIds;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment=payment;
    }
}
