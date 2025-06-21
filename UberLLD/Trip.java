package UberLLD;

import UberLLD.payment.*;
import payment.PaymentStatus;

import java.util.UUID;

public class Trip {
    private final String id;
    private final Rider rider;
    private Driver driver;
    private final Location origin;
    private final Location destination;
    private TripStatus tripStatus;
    private PaymentStatus paymentStatus;
    private double fare;

    public Trip(Rider rider, Location origin, Location destination) {
        this.id=UUID.randomUUID().toString();
        this.rider=rider;
        this.origin=origin;
        this.destination=destination;
        this.tripStatus=TripStatus.REQUESTED;
        this.paymentStatus=PaymentStatus.PENDING;
    }

    public void complete() {
        tripStatus=TripStatus.COMPLETED;
    }

    public void markPayment() {
        paymentStatus=PaymentStatus.COMPLETED;
    }

    public void assignDriver(Driver driver) {
        this.driver=driver;
    }

    public void setTripStatus(TripStatus tripStatus) {
        this.tripStatus=tripStatus;
    }

    public String getId() {
        return id;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public TripStatus getTripStatus() {
        return tripStatus;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public double getFare() {
        return fare;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }


}
