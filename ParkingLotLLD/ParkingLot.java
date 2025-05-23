package ParkingLotLLD;

import ParkingLotLLD.fee.FeeStrategy;
import ParkingLotLLD.fee.VehicleBasedFeeStrategy;
import ParkingLotLLD.vehicletype.Vehicle;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class ParkingLot {
    private static ParkingLot instance;
    private final List<ParkingFloor> floors;
    private final Map<String,Ticket> activeTickets=new ConcurrentHashMap<>();
    private FeeStrategy feeStrategy;

    private ParkingLot() {
        floors=new ArrayList<>();
        feeStrategy=new VehicleBasedFeeStrategy();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance==null)
            instance=new ParkingLot();

        return instance;
    }

    public void addFloor(ParkingFloor floor) {
        floors.add(floor);
    }

    public void setFeeStrategy(FeeStrategy feeStrategy) {
        this.feeStrategy=feeStrategy;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle) throws Exception {
        for (ParkingFloor floor: floors) {
            Optional<ParkingSpot> spotOpt=floor.getAvailableSpot(vehicle.getType());

            if (spotOpt.isPresent()) {
                ParkingSpot spot=spotOpt.get();

                if (spot.park(vehicle)) {
                    String ticketId= UUID.randomUUID().toString();
                    Ticket ticket=new Ticket(ticketId,vehicle,spot);
                    activeTickets.put(ticketId,ticket);
                    return ticket;
                }
            }
        }

        throw  new Exception("No avaiable spot for "+vehicle.getType());
    }

    public synchronized  double unparkVehicle(String ticketId) throws Exception {
        Ticket ticket=activeTickets.get(ticketId);
        if (ticket==null)
            throw new Exception("Invalid ticket");

        ParkingSpot spot=ticket.getSpot();
        spot.unpark();

        ticket.setExitTimestamp();
        return feeStrategy.calculateFee(ticket);
    }

    public List<ParkingFloor> getParkingFloors() {
        return floors;
    }
}
