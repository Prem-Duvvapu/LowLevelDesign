package BookMyShow;
import java.util.*;

public class Theatre {
    int id;
    String name;
    String address;
    City city;
    List<Screen> screensList;
    List<Show> showsList;

    Theatre(int id,String name,City city) {
        this.id=id;
        this.name=name;
        this.city=city;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address=address;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city=city;
    }

    public List<Screen> getScreensList() {
        return screensList;
    }

    public void setScreensList(List<Screen> screenList) {
        this.screensList=screensList;
    }

    public List<Show> getShowsList() {
        return showsList;
    }

    public void getShowsList(List<Show> showsList) {
        this.showsList=showsList;
    }
}
