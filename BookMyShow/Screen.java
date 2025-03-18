package BookMyShow;
import java.util.*;

public class Screen {
    int id;
    List<Seat> seatsList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public List<Seat> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seat> seatsList) {
        this.seatsList=seatsList;
    }
}
