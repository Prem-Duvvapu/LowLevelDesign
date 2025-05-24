package CarRentalSystemLLD;

public class Location {
    public String address;
    public int pincode;
    public String city;
    public String state;
    public String country;

    public Location(int pincode,String city,String state,String country) {
        this.pincode=pincode;
        this.city=city;
        this.state=state;
        this.country=country;
    }
}
