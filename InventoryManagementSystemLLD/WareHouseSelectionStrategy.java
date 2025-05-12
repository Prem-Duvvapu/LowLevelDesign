package InventoryManagementSystemLLD;

import java.util.List;

public interface WareHouseSelectionStrategy {
    Warehouse selectWarehouse(List<Warehouse> warehouseList);
}
