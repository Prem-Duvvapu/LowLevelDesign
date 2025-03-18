package BookMyShow;
import java.util.*;

public class MovieController {
    Map<City,List<Movie>> moviesInCity;
    List<Movie> allMovies;

    MovieController() {
        moviesInCity=new HashMap<>();
        allMovies=new ArrayList<>();
    }

    public void addMovie(Movie movie,City city) {
        List<Movie> moviesList=moviesInCity.getOrDefault(city, new ArrayList<>());

        moviesList.add(movie);
        moviesInCity.put(city,moviesList);
        allMovies.add(movie);
    }

    public List<Movie> getMoviesByCity(City city) {
        return moviesInCity.get(city);
    }

    public Movie getMovieByName(String movieName) {
        for (Movie m: allMovies) {
            if (m.getName().equals(movieName))
                return m;
        }

        return null;
    }

    public List<Movie> getAllMovies() {
        return allMovies;
    }
}
