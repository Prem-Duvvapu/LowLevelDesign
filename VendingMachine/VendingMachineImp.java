package VendingMachine;

import java.util.*;

public class VendingMachineImp {
    VendingMachineState machineState;
    Inventory inventory;
    List<Coin> coinsList;

    VendingMachineImp() {
        machineState=new IdleState();
        inventory=new Inventory();
        coinsList=new ArrayList<>();
    }

    VendingMachineState getVendingMachineState() {
        return machineState;
    }

    void setVendingMachineState(VendingMachineState machineState) {
        this.machineState=machineState;
    }

    Inventory getInventory() {
        return inventory;
    }

    void setInventory(Inventory inventory) {
        this.inventory=inventory;
    }

    List<Coin> getCoinsList() {
        return coinsList;
    }

    void setCoinsList(List<Coin> coinsList) {
        this.coinsList=coinsList;
    }
}
