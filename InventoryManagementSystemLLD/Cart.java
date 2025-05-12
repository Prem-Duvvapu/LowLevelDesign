package InventoryManagementSystemLLD;

import java.util.HashMap;
import java.util.Map;

public class Cart {
    Map<Integer,Integer> productCategoryIdVsCountMap;

    public Cart() {
        productCategoryIdVsCountMap=new HashMap<>();
    }

    public void addItemInCart(int productCategoryId,int count) {
        if (productCategoryIdVsCountMap.containsKey(productCategoryId)) {
            int numOfItemsInCart=productCategoryIdVsCountMap.get(productCategoryId);
            productCategoryIdVsCountMap.put(productCategoryId,numOfItemsInCart+count);
        } else {
            productCategoryIdVsCountMap.put(productCategoryId,count);
        }
    }

    public void removeItemFromCart(int productCategoryId,int count) {
        int numOfItemsInCart=productCategoryIdVsCountMap.get(productCategoryId);
        if (numOfItemsInCart-count==0)
            productCategoryIdVsCountMap.remove(productCategoryId);
        else
            productCategoryIdVsCountMap.put(productCategoryId,numOfItemsInCart-count);
    }

    public void emptyCart() {
        productCategoryIdVsCountMap=new HashMap<>();
    }

    public Map<Integer,Integer> getCartItems() {
        return productCategoryIdVsCountMap;
    }
}
