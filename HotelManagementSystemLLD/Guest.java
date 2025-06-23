package HotelManagementSystemLLD;

public class Guest {
    private final String id;
    private String name;
    private String email;
    private String phoneNumber;

    public Guest(String id, String name, String email, String phoneNumber) {
        this.id=id;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
