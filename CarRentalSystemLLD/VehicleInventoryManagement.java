package CarRentalSystemLLD;

import CarRentalSystemLLD.Product.Vehicle;

import java.util.List;

public class VehicleInventoryManagement {
    public List<Vehicle> vehicles;

    public VehicleInventoryManagement(List<Vehicle> vehicles) {
        this.vehicles=vehicles;
    }

    public void setVehicles(List<Vehicle> vehicles) {
        this.vehicles=vehicles;
    }
}
