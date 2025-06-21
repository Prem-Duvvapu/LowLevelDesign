package UberLLD;

public class Location {
    private double latitude;
    private double longitude;

    public Location(double latitude,double longitude) {
        this.latitude=latitude;
        this.longitude=longitude;
    }

    public double distancTo(Location that) {
        double dx=this.latitude-that.latitude;
        double dy=this.longitude-that.longitude;

        return Math.sqrt(dx*dx + dy*dy);
    }
}
