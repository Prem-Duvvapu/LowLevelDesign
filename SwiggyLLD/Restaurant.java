package SwiggyLLD;

import java.util.*;

public class Restaurant {
    private final String id;
    private String name;
    private String address;
    private List<MenuItem> menu;

    public Restaurant(String name, String address) {
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.address=address;
        menu=new ArrayList<>();
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void removeMenuItem(MenuItem item) {
        menu.remove(item);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public List<MenuItem> getMenu() {
        return menu;
    }

    public void setMenu(List<MenuItem> menu) {
        this.menu = menu;
    }

    
}


