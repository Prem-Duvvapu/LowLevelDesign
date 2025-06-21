package UberLLD;

import java.util.UUID;

public class User {
    private final String id;
    private String name;
    private String contact;

    public User(String name, String contact) {
        this.id=UUID.randomUUID().toString();
        this.name=name;
        this.contact=contact;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public void setName(String name) {
        this.name=name;
    }

    public void setContact(String contact) {
        this.contact=contact;
    }
}
