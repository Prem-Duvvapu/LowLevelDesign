package InventoryManagementSystemLLD;

import java.nio.file.WatchService;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main MainObj=new Main();

        //1. create warehouses in the system
        List<Warehouse> warehouseList=new ArrayList<>();
//        warehouseList.add(mainOb)
    }

    private Warehouse addWarehouseAndItsInventory() {
        Warehouse warehouse=new Warehouse();
        Inventory inventory=new Inventory();

        inventory.addNewCategory(1, "Thums Up Cool Drink", 100);
        inventory.addNewCategory(3,"Sprite Cool Drink",50);

        //create products
        Product product1=new Product();
        product1.productId=1;
        product1.productName="Thums Up";

        Product product2=new Product();
        product2.productId=2;
        product2.productName="Sprite";

        Product product3=new Product();
        product3.productId=3;
        product3.productName="Sprite";

        inventory.addProduct(product1,1);
        inventory.addProduct(product2,3);
        inventory.addProduct(product3,3);

        warehouse.inventory=inventory;
        return warehouse;
    }

    private User createUser() {
        User user=new User();
        user.userId=3;
        user.userName="Prem";
        user.address=new Address(123456,"Bangalore","Karnataka");

        return user;
    }

    private void runDeliveryFlow(ProductDeliverySystem productDeliverySystem,int userId) {
        //1. Get the user object
        User user= productDeliverySystem.getUser(userId);

        //2. Get warehouse based on strategy
        Warehouse warehouse= productDeliverySystem.getWarehouse(new NearestWarehouseSelectionStrategy());

        //3. get all the inventory to show the user
        Inventory inventory=productDeliverySystem.getInventory(warehouse);

        ProductCategory productCategoryIWantToOrder=null;
        for (ProductCategory productCategory: inventory.productCategoryList) {
            if (productCategory.categoryName.equals("Sprite Cool Drink"))
                    productCategoryIWantToOrder=productCategory;
        }

        //4. add product to the cart
        productDeliverySystem.addProductToCart(user,productCategoryIWantToOrder,2);

        //5. place order
        Order order=productDeliverySystem.placeOrder(user,warehouse);

        //6. checkout
        productDeliverySystem.checkout(order);
    }
}
