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

    
}


