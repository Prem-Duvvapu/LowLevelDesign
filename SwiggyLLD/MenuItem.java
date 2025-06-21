package SwiggyLLD;

import java.util.UUID;

public class MenuItem {
    private final String id;
    private String name;
    private String description;
    private double price;
    private boolean available;

    public MenuItem(String name, String description, double price) {
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.description=description;
        this.price=price;
        this.available=true;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
    
    public String getMenuItem() {
        return "Name: " + name + ", Description: " + description + ", Price: " + price;
    }
}
