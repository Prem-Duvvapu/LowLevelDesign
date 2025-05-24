package CarRentalSystemLLD;

import java.util.List;

public class VehicleRentalSystem {
    public List<Store> storeList;
    public List<User> userList;

    public VehicleRentalSystem(List<Store> storeList,List<User> userList) {
        this.storeList=storeList;
        this.userList=userList;
    }

    public Store getStore(Location location) {
        return storeList.get(0);
    }

    //add users

    //remove users

    //add stores

    //remove stores
}
