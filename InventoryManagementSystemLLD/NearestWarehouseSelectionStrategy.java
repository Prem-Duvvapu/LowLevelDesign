package InventoryManagementSystemLLD;

import java.util.List;

public class NearestWarehouseSelectionStrategy implements WareHouseSelectionStrategy {
    @Override
    public Warehouse selectWarehouse(List<Warehouse> warehouseList) {
        return warehouseList.get(0);
    }
}
