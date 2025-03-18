package BookMyShow;

public class Movie {
    int id;
    String name;
    int movieDurationInMins;

    Movie(int id,String name,int movieDurationInMins) {
        this.id=id;
        this.name=name;
        this.movieDurationInMins=movieDurationInMins;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id=id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name=name;
    }

    public int getMovieDurationInMins() {
        return movieDurationInMins;
    }

    public void setMovieDurationInMins(int movieDurationInMins) {
        this.movieDurationInMins=movieDurationInMins;
    }
}
