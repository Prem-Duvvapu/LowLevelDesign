package ParkingLotLLD.fee;

import ParkingLotLLD.Ticket;

public interface FeeStrategy {
    double calculateFee(Ticket ticket);
}
