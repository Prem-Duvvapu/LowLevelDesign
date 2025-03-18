package BookMyShow;
import java.util.*;

public class Theatre {
    int id;
    String name;
    City city;
    List<Screen> screensList;
    List<Show> showsList;

    Theatre(int id,String name,City city) {
        this.id=id;
        this.name=name;
        this.city=city;
    }

}
