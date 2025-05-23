package ParkingLotLLD;

import ParkingLotLLD.vehicletype.Vehicle;
import ParkingLotLLD.vehicletype.VehicleType;

import java.util.List;
import java.util.Optional;

public class ParkingFloor {
    private final int floorNumber;
    private final List<ParkingSpot> parkingSpots;

    public ParkingFloor(int floorNumber,List<ParkingSpot> parkingSpots) {
        this.floorNumber=floorNumber;
        this.parkingSpots=parkingSpots;
    }

    public synchronized Optional<ParkingSpot> getAvailableSpot(VehicleType type) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType()==type)
                .findFirst();
    }

    public List<Integer> getAvailableSpots(VehicleType type) {
        return parkingSpots.stream()
                .filter(spot -> spot.isAvailable() && spot.getVehicleType()==type)
                .map(ParkingSpot::getSpotNumber)
                .toList();
    }

    public int getFloorNumber() {
        return floorNumber;
    }

    public List<ParkingSpot> getParkingSpots() {
        return parkingSpots;
    }
}
