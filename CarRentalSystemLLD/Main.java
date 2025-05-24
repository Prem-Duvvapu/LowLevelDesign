package CarRentalSystemLLD;

import CarRentalSystemLLD.Product.Car;
import CarRentalSystemLLD.Product.Vehicle;
import CarRentalSystemLLD.Product.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users=addUsers();
        List<Vehicle> vehicles=addVehicles();
        List<Store> stores=addStores(vehicles);

        VehicleRentalSystem rentalSystem=new VehicleRentalSystem(stores,users);

        //0. user comes
        User user=users.get(0);
        System.out.println("0. User came");

        //1. user search store based on location
        Location location=new Location(123456,"Bangalore","Karnataka","India");
        Store store=rentalSystem.getStore(location);
        System.out.println("1. User searched store based on location");

        //2. get all vehicles user is interested in (based on different filters)
        List<Vehicle> storeVehicles=store.getVehicles(VehicleType.CAR);
        System.out.println("2. User applied filters and got all vehicles he/she interested in");

        //3. reserving the particular vehicle
        Reservation reservation=store.createReservation(storeVehicles.get(0),user);
        System.out.println("3. User reserved the vehicle");

        //4. generate the bill
        Bill bill=new Bill(reservation);
        System.out.println("4. Bill generated");

        //5 .make payment
        Payment payment=new Payment();
        payment.payBill(bill);
        System.out.println("5. User paid the bill");

        //6. trip completed, submit the vehicle and close the reservation
        store.completeReservation(reservation.reservationId);
        System.out.println("6. Trip completed, user submitted the vehicle and reservation is closed");
    }

    public static List<User> addUsers() {
        List<User> users=new ArrayList<>();
        User user1=new User();
        user1.userId=1;

        users.add(user1);
        return users;
    }

    public static List<Vehicle> addVehicles() {
        List<Vehicle> vehicles=new ArrayList<>();

        Vehicle vehicle1=new Car();
        vehicle1.vehicleID=1;
        vehicle1.vehicleType=VehicleType.CAR;

        Vehicle vehicle2=new Car();
        vehicle2.vehicleID=2;
        vehicle2.vehicleType=VehicleType.CAR;

        vehicles.add(vehicle1);
        vehicles.add(vehicle2);

        return vehicles;
    }


    public static List<Store> addStores(List<Vehicle> vehicles) {
        List<Store> stores=new ArrayList<>();
        Store store1=new Store();
        store1.storeId=1;
        store1.setVehicles(vehicles);

        stores.add(store1);
        return stores;
    }
}
