package HotelManagementSystemLLD;

import HotelManagementSystemLLD.payment.CreditCardPayment;
import HotelManagementSystemLLD.payment.Payment;

import java.time.LocalDate;

public class Demo {
    public static void main(String[] args) {
        HotelManagementSystem system=HotelManagementSystem.getInstance();

        //Create guests
        Guest guest1=new Guest("G1","Luffy","luffy@op.com","123456");
        Guest guest2=new Guest("G2","Zoro","zoro@op.com","234567");
        system.addGuest(guest1);
        system.addGuest(guest2);

        //Create rooms
        Room room1=new Room("R1",RoomType.SINGLE,100.0);
        Room room2=new Room("R2",RoomType.DELUXE,200.0);
        system.addRoom(room1);
        system.addRoom(room2);

        //Book a room
        LocalDate checkInDate=LocalDate.now();
        LocalDate checkOutDate=checkInDate.plusDays(3);
        Reservation reservation1=null;
        try {
            reservation1=system.reserveRoom(guest1,room1,checkInDate,checkOutDate);
        } catch (Exception e) {
            System.out.println("Exception occured during reservation: "+e.getMessage());
        }

        //Check-in
        if (reservation1!=null) {
            system.checkIn(reservation1.getId());
            System.out.println("Checked in: " + reservation1.getId());
        }

        //Check-out and make payment
        Payment payment=new CreditCardPayment();
        if (reservation1!=null) {
            system.checkOut(reservation1.getId(),payment);
            System.out.println("Checked out: "+reservation1.getId());
        }

        //Cancel a reservation
        Reservation reservation2=system.reserveRoom(guest2,room2,LocalDate.now(),LocalDate.now().plusDays(5));
        system.cancelReservation(reservation2.getId());
        System.out.println("Reservation cancelled: "+reservation2.getId());
    }
}
