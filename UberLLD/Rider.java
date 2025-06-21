package UberLLD;

public class Rider extends User {
    private Trip currentTrip;

    public Rider(String name,String contact) {
        super(name, contact);
    }

    public synchronized void assignTrip(Trip trip) {
        currentTrip=trip;
    }

    public synchronized void completeTrip(Trip trip) {
        currentTrip=null;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }
}
