package CarRentalSystemLLD;

import CarRentalSystemLLD.Product.Vehicle;

import java.util.Date;

public class Reservation {
    public int reservationId;
    public User user;
    public Vehicle vehicle;
    public Date bookingDate;
    public Date dateBookedFrom;
    public Date dateBookedTo;
    public long fromTimeStamp;
    public long toTimeStamp;
    public Location pickUpLocation;
    public Location dropLocation;
    public ReservationType reservationType;
    public ReservationStatus reservationStatus;
    public Location location;

    public int createReserve(User user,Vehicle vehicle) {
        //generateId
        reservationId=12321;
        this.user=user;
        this.vehicle=vehicle;
        reservationType=ReservationType.DAILY;
        reservationStatus=ReservationStatus.SCHEDULED;

        return reservationId;
    }
}
