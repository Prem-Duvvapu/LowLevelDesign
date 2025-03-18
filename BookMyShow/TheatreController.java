package BookMyShow;
import java.util.*;

public class TheatreController {
    Map<City,List<Theatre>> theatresInCity;
    List<Theatre> allTheatres;

    public TheatreController() {
        theatresInCity=new HashMap<>();
        allTheatres=new ArrayList<>();
    }

    public void addTheatre(City city,Theatre theatre) {
        List<Theatre> theatresList=theatresInCity.getOrDefault(city,new ArrayList<>());
        theatresList.add(theatre);
        theatresInCity.put(city,theatresList);

        allTheatres.add(theatre);
    }

    public List<Theatre> getTheatresByCity(City city) {
        return theatresInCity.get(city);
    }

    public Map<Theatre,List<Show>> getMovieShowsByCity(City city,Movie movie) {
        Map<Theatre,List<Show>> allReqMovieShows=new HashMap<>();
        List<Theatre> theatres=theatresInCity.get(city);

        for (Theatre theatre: theatres) {
            List<Show> allCurrTheatreShows=theatre.getShowsList();
            List<Show> reqShows=new ArrayList<>();
            
            for (Show show: allCurrTheatreShows) {
                if (show.getMovie().getId()==movie.getId())
                    reqShows.add(show);
            }

            if (!reqShows.isEmpty())
                allReqMovieShows.put(theatre,reqShows);
        }

        return allReqMovieShows;
    }
}
