package CarRentalSystemLLD.Product;

import java.util.Date;

public abstract class Vehicle {
    public int vehicleID;
    public int vehicleNumber;
    public VehicleType vehicleType;
    public String companyName;
    public String modelName;
    public int kmDriven;
    public Date manufacturingDate;
    public int average;
    public int cc;
    public int dailyRentalCost;
    public int hourlyRentalCost;
    public int noOfSeat;
    public Status status;
}
