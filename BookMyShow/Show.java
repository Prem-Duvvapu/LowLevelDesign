package BookMyShow;
import java.util.*;

public class Show {
    int id;
    Movie movie;
    Screen screen;
    String startTime;
    List<Seat> seatsList;
    List<Integer> bookingIds;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie=movie;
    }

    public Screen getScreen() {
        return screen;
    }

    public void setScreen(Screen screen) {
        this.screen=screen;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime=startTime;
    }

    public List<Seat> getSeatsList() {
        return seatsList;
    }

    public void setSeatsList(List<Seat> seatsList) {
        this.seatsList=seatsList;
    }

    public List<Integer> getBookingIds() {
        return bookingIds;
    }

    public void setBookingIds(List<Integer> bookingIds) {
        this.bookingIds=bookingIds;
    }
}
