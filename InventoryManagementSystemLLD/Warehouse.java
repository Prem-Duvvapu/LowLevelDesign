package InventoryManagementSystemLLD;

import java.util.Map;

public class Warehouse {
    public Inventory inventory;
    public Address address;

    public void addItemToInventory(Map<Integer,Integer> productCategoryAndCountMap) {
        //add items to inventory based upon product category
    }

    public void removeFromInventory(Map<Integer,Integer> productCategoryAndCountMap) {
        inventory.removeItems(productCategoryAndCountMap);
    }

}
