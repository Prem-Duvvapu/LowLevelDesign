package InventoryManagementSystemLLD;

public class Address {

    public String city;
    public String state;
    public int pinCode;

    public Address(int pinCode,String city,String state) {
        this.pinCode=pinCode;
        this.city=city;
        this.state=state;
    }
}
