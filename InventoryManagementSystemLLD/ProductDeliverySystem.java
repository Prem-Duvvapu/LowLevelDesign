package InventoryManagementSystemLLD;

import java.util.List;

public class ProductDeliverySystem {
    public UserController userController;
    public WarehouseController warehouseController;
    public OrderController orderController;

    public ProductDeliverySystem(List<User> userList, List<Warehouse> warehouseList) {
        userController=new UserController(userList);
        warehouseController=new WarehouseController(warehouseList,null);
        orderController=new OrderController();
    }

    public User getUser(int userId) {
        return userController.getuser(userId);
    }

    public Warehouse getWarehouse(WareHouseSelectionStrategy wareHouseSelectionStrategy) {
        return warehouseController.selectWarehouse(wareHouseSelectionStrategy);
    }

    public Inventory getInventory(Warehouse warehouse) {
        return warehouse.inventory;
    }

    public void addProductToCart(User user,ProductCategory productCategory,int count) {
        Cart cart=user.userCartDetails;
        cart.addItemInCart(productCategory.productCategoryId,count);
    }

    public Order placeOrder(User user,Warehouse warehouse) {
        return orderController.createOrder(user,warehouse);
    }

    public void checkout(Order order) {
        order.checkout();
    }
}
