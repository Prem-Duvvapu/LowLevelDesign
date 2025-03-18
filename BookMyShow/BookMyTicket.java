package BookMyShow;

import java.util.*;

public class BookMyTicket {
    MovieController movieController=new MovieController();
    TheatreController theatreController=new TheatreController();

    public void BookMyTicket() {
        movieController=new MovieController();
        theatreController=new TheatreController();
    }

    public static void main(String[] args) {
        BookMyTicket ticket=new BookMyTicket();
        ticket.initialize();

        ticket.createBooking(City.Bangalore,"Bahubali");
        ticket.createBooking(City.Bangalore,"Bahubali");
    }

    public void initialize() {
        createMovies();
        createTheatres();
    }

    public void createBooking(City city, String movieName) {
        //1. Get the list of all movies in city
        List<Movie> allMoviesInCity=movieController.getMoviesByCity(city);

        //2. Select the movie you want to watch
        Movie interestedMovie=null;
        for (Movie movie: allMoviesInCity) {
            if (movie.getName().equals(movieName)) {
                interestedMovie=movie;
                break;
            }
        }

        //3. Get the list of shows available in the city theatres for this movie
        Map<Theatre,List<Show>> movieTheatreShows=theatreController.getMovieShowsByCity(city, interestedMovie);

        //4. Select a show from the theatre screen
        Map.Entry<Theatre,List<Show>> entry=movieTheatreShows.entrySet().iterator().next();
        List<Show> availableShows=entry.getValue();
        Show interestedShow=availableShows.get(0);

        //5. Select the seat
        int interestedSeatNumber=30;

        List<Integer> bookedIds=interestedShow.getBookingIds();

        if (!bookedIds.contains(interestedSeatNumber)) {
            bookedIds.add(interestedSeatNumber);

            Booking booking=new Booking();
            List<Seat> bookingSeats=new ArrayList<>();

            for (Seat seat: interestedShow.getScreen().getSeatsList()) {
                if (seat.getId()==interestedSeatNumber) {
                    bookingSeats.add(seat);
                }
            }

            booking.setBookedSeats(bookingSeats);
            interestedShow.setBookingIds(bookedIds);
        } else {
            System.out.println("Seat Already Booked. Please try again...");
            return;
        }

        System.out.println("BOOKING SUCCESSFUL");
    }
    
    //To create theatres
    public void createTheatres() {
        Movie avengers=movieController.getMovieByName("Avengers");
        Movie bahubali=movieController.getMovieByName("Bahubali");

        Theatre inoxTheatre=new Theatre(1,"Inox",City.Bangalore);
        List<Screen> inoxTheatreScreens=new ArrayList<>();
        inoxTheatreScreens.add(createScreen(1));
        List<Show> inoxTheatreShows=new ArrayList<>();
        Show inoxMorningShow=createShow(1,bahubali,inoxTheatreScreens.get(0),"9AM");
        Show inoxEveningShow=createShow(2,bahubali,inoxTheatreScreens.get(0),"6PM");
        inoxTheatreShows.add(inoxMorningShow);
        inoxTheatreShows.add(inoxEveningShow);
        inoxTheatre.setShowsList(inoxTheatreShows);


        Theatre pvrTheatre=new Theatre(2,"Pvr",City.Hyderabad);
        List<Screen> pvrTheatreScreens=new ArrayList<>();
        pvrTheatreScreens.add(createScreen(2));
        List<Show> pvrTheatreShows=new ArrayList<>();
        Show pvrMorningShow=createShow(3,avengers,pvrTheatreScreens.get(0),"9AM");
        Show pvrEveningShow=createShow(4,avengers,pvrTheatreScreens.get(0),"6PM");
        pvrTheatreShows.add(pvrMorningShow);
        pvrTheatreShows.add(pvrEveningShow);
        pvrTheatre.setShowsList(pvrTheatreShows);

        theatreController.addTheatre(City.Bangalore, inoxTheatre);
        theatreController.addTheatre(City.Hyderabad, pvrTheatre);
    }

    //To create screen
    public Screen createScreen(int id) {
        Screen screen=new Screen();
        screen.setId(id);
        screen.setSeatsList(createSeats());

        return screen;
    }

    //To create show
    public Show createShow(int id,Movie movie,Screen screen,String startTime) {
        Show show=new Show();
        show.setId(id);
        show.setMovie(movie);
        show.setScreen(screen);
        show.setStartTime(startTime);

        return show;
    }

    //To create seats()
    public List<Seat> createSeats() {
        //For general purpose, I'm taking 100 seats
        List<Seat> seatsList=new ArrayList<>();

        //50 silver seats
        for (int i=1;i<=50;i++) {
            Seat seat=new Seat();
            seat.setId(i);
            seat.setSeatCategory(SeatCategory.SILVER);
            seatsList.add(seat);
        }

        //30 gold seats
        for (int i=51;i<=80;i++) {
            Seat seat=new Seat();
            seat.setId(i);
            seat.setSeatCategory(SeatCategory.GOLD);
            seatsList.add(seat);
        }

        //20 platinum seats
        for (int i=18;i<=100;i++) {
            Seat seat=new Seat();
            seat.setId(i);
            seat.setSeatCategory(SeatCategory.PLATINUM);
            seatsList.add(seat);
        }

        return seatsList;
    }

    //To create movies
    public void createMovies() {
        Movie avengers=new Movie(1,"Avengers",150);
        Movie bahubali=new Movie(2,"Bahubali",180);

        movieController.addMovie(avengers,City.Bangalore);
        movieController.addMovie(bahubali,City.Bangalore);

        movieController.addMovie(avengers,City.Hyderabad);
        movieController.addMovie(bahubali,City.Hyderabad);
    }
}
