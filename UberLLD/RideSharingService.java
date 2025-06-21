package UberLLD;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class RideSharingService {
    private static RideSharingService instace;
    private Map<String, Rider> riders;
    private Map<String, Driver> drivers;
    private Map<String, Trip> trips;

    private RideSharingService() {
        riders=new ConcurrentHashMap<>();
        drivers=new ConcurrentHashMap<>();
        trips=new ConcurrentHashMap<>();
    }

    public static RideSharingService getInstance() {
        if (instace==null)
            instace=new RideSharingService();

        return instace;
    }

    public Rider registerRider() {

    }

    public Driver registerDriver() {

    }

    public void updateDriverLocation() {

    }

    public synchronized Trip requestRide() {

    }

    public synchronized void acceptRide() {

    }

    public void startRide() {

    }

    public void completeRide() {

    }

    public void cancelRide() {

    }

    public void markPayment() {

    }

    private void notifyNearbyDrivers(Trip trip) {

    }

    private void notifyRider(Trip trip) {

    }

    private void notifyDriver(Trip trip) {

    }

    private double calculateFee(Trip trip) {
        
    }
}
