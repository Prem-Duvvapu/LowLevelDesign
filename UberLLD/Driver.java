package UberLLD;

public class Driver extends User {
    private String licensePlate;
    private Location location;
    private Trip currentTrip;
    private DriverStatus status;

    public Driver(String name,String contact,String licensePlate,Location location) {
        super(name,contact);
        this.licensePlate=licensePlate;
        this.location=location;
        this.status=DriverStatus.AVAILABLE;
    }

    public synchronized void updateLocation(Location location) {
        this.location=location;
    }

    public synchronized boolean isAvailable() {
        return status==DriverStatus.AVAILABLE;
    }

    public synchronized void assignTrip(Trip trip) {
        this.currentTrip=trip;
        status=DriverStatus.BUSY;
    }

    public synchronized void completeTrip() {
        status=DriverStatus.AVAILABLE;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    
}
