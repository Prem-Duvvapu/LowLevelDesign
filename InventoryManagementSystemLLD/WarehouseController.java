package InventoryManagementSystemLLD;

import java.util.List;

public class WarehouseController {
    List<Warehouse> wareHouseList;
    WareHouseSelectionStrategy wareHouseSelectionStrategy=null;

    public WarehouseController(List<Warehouse> warehouseList,WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouseList=warehouseList;
        this.wareHouseSelectionStrategy=wareHouseSelectionStrategy;
    }

    public void addWarehouse(Warehouse warehouse) {
        wareHouseList.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        wareHouseList.remove(warehouse);
    }

    public Warehouse selectWarehouse(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        this.wareHouseSelectionStrategy=wareHouseSelectionStrategy;
        return wareHouseSelectionStrategy.selectWarehouse(wareHouseList);
    }
}
