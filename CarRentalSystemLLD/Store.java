package CarRentalSystemLLD;

import CarRentalSystemLLD.Product.Vehicle;
import CarRentalSystemLLD.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Store {
    public int storeId;
    public VehicleInventoryManagement inventoryManagement;
    public Location storeLocation;
    List<Reservation> reservations=new ArrayList<>();

    public List<Vehicle> getVehicles(VehicleType vehicleType) {
        return inventoryManagement.vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        inventoryManagement=new VehicleInventoryManagement(vehicles);
    }

    public Reservation createReservation(Vehicle vehicle,User user) {
        Reservation reservation=new Reservation();
        reservation.createReserve(user,vehicle);
        reservations.add(reservation);
        return reservation;
    }

    public boolean completeReservation(int reservationId) {
        //take out the reservation from the list and call complete the reservation method
        return true;
    }
}
