package SwiggyLLD;

import java.util.UUID;

public class DeliveryAgent {
    public final String id;
    private String name;
    private String phone;
    private boolean available;

    public DeliveryAgent(String name, String phone) {
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.phone=phone;
        this.available=true;
    }

    public void setAvailable(boolean available) {
        this.available=available;
    }

    public synchronized boolean isAvailable() {
        return available;
    }

    public synchronized void assign() {
        if (!available)
            throw new IllegalStateException("Already assigned");
        available=false;
    }

    public synchronized void release() {
        available=true;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
