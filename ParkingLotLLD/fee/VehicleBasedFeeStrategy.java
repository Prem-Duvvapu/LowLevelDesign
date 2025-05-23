package ParkingLotLLD.fee;

import ParkingLotLLD.Ticket;
import ParkingLotLLD.vehicletype.VehicleType;

import java.util.Map;

public class VehicleBasedFeeStrategy implements FeeStrategy {
    private final Map<VehicleType,Double> hourlyRates=Map.of(
            VehicleType.BIKE, 10.0,
            VehicleType.CAR, 20.0,
            VehicleType.TRUCK, 30.0
    );

    @Override
    public double calculateFee(Ticket ticket) {
        long duration= ticket.getExitTimestamp()- ticket.getEntryTimestamp();
        long hours=(duration/(60*60*1000))+1;
        return hours*hourlyRates.get(ticket.getVehicle().getType());
    }
}
