package ParkingLotLLD;

import ParkingLotLLD.fee.VehicleBasedFeeStrategy;
import ParkingLotLLD.vehicletype.Bike;
import ParkingLotLLD.vehicletype.Car;
import ParkingLotLLD.vehicletype.Vehicle;
import ParkingLotLLD.vehicletype.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLotDemo demo=new ParkingLotDemo();
        demo.run();
    }

    public void run() {
        ParkingLot parkingLot = ParkingLot.getInstance();

        List<ParkingSpot> parkingSpotsFloor1 = List.of(
                new ParkingSpot(101, VehicleType.CAR),
                new ParkingSpot(102, VehicleType.CAR),
                new ParkingSpot(103, VehicleType.BIKE)
        );

        List<ParkingSpot> parkingSpotsFloor2 = List.of(
                new ParkingSpot(201, VehicleType.CAR),
                new ParkingSpot(202, VehicleType.BIKE)
        );

        ParkingFloor floor1 = new ParkingFloor(1, parkingSpotsFloor1);
        ParkingFloor floor2 = new ParkingFloor(2, parkingSpotsFloor2);
        parkingLot.addFloor(floor1);
        parkingLot.addFloor(floor2);

        parkingLot.setFeeStrategy(new VehicleBasedFeeStrategy());

        //Create vehicles
        Vehicle car1=new Car("ABC123");
        Vehicle car2=new Car("XYZ789");
        Vehicle bike1=new Bike("PQ456");

        //View available spots
        System.out.println("Available spots for Car:");
        for (ParkingFloor floor: parkingLot.getParkingFloors())
            System.out.println("Floor: "+floor.getFloorNumber()+" "+floor.getAvailableSpots(VehicleType.CAR));

        List<String> parkingTickets=new ArrayList<>();

        //Park vehicles
        try {
            Ticket ticket1=parkingLot.parkVehicle(car1);
            System.out.println("Car 1 parked: "+ticket1.getTicketId());
            parkingTickets.add(ticket1.getTicketId());
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }

        try {
            double fee=parkingLot.unparkVehicle(parkingTickets.get(0));
            System.out.println("Ticket: "+parkingTickets.get(0)+", Fee: "+fee);
        } catch (Exception e) {
            System.out.println("Exception: "+e.getMessage());
        }
    }
}
