package HotelManagementSystemLLD;

import HotelManagementSystemLLD.payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class HotelManagementSystem {
    private static HotelManagementSystem instance;
    private Map<String, Guest> guests;
    private Map<String, Room> rooms;
    private Map<String, Reservation> reservations;

    private HotelManagementSystem() {
        this.guests=new ConcurrentHashMap<>();
        this.rooms=new ConcurrentHashMap<>();
        this.reservations=new ConcurrentHashMap<>();
    }

    public static synchronized HotelManagementSystem getInstance() {
        if (instance==null)
            instance=new HotelManagementSystem();

        return instance;
    }

    public void addGuest(Guest guest) {
        guests.put(guest.getId(), guest);
    }

    public Guest getGuest(String guestId) {
        return guests.get(guestId);
    }

    public void addRoom(Room room) {
        rooms.put(room.getId(), room);
    }

    public Room getRoom(String roomId) {
        return rooms.get(roomId);
    }

    public synchronized Reservation reserveRoom(Guest guest, Room room, LocalDate checkInDate, LocalDate checkOutDate) {
        if (room.getStatus()!=RoomStatus.AVAILABLE)
            throw new IllegalStateException("Room is not available");

        room.book();
        String reservationId=generateReservationId();
        Reservation reservation=new Reservation(reservationId,guest,room,checkInDate,checkOutDate);
        reservations.put(reservationId, reservation);
        return reservation;
    }

    public synchronized void cancelReservation(String reservationId) {
        Reservation reservation=reservations.get(reservationId);
        if (reservation==null)
            throw new IllegalArgumentException("No reservation found with reservation ID: "+reservationId);

        reservation.cancel();
        reservations.remove(reservationId);
    }

    public synchronized void checkIn(String reservationId) {
        Reservation reservation=reservations.get(reservationId);
        if (reservation==null)
            throw new IllegalArgumentException("No reservation found with reservation ID: "+reservationId);

        if (reservation.getStatus()!=ReservationStatus.CONFIRMED)
            throw new IllegalStateException("Reservation is not confirmed.");

        reservation.getRoom().checkIn();
    }

    public synchronized void checkOut(String reservationId, Payment payment) {
        Reservation reservation=reservations.get(reservationId);
        if (reservation==null)
            throw new IllegalArgumentException("No reservation found with reservation ID: "+reservationId);

        if (reservation.getStatus()!=ReservationStatus.CONFIRMED)
            throw new IllegalStateException("Reservation is not confirmed.");

        Room room=reservation.getRoom();
        double amount=room.getPrice() * ChronoUnit.DAYS.between(reservation.getCheckInDate(), reservation.getCheckOutDate());

        if (payment.processPayment(amount)) {
            room.checkOut();
            reservations.remove(reservationId);
        } else {
            throw new IllegalStateException("Payment failed!");
        }
    }


    private String generateReservationId() {
        return "RES"+ UUID.randomUUID().toString().substring(0,8).toUpperCase();
    }
}
