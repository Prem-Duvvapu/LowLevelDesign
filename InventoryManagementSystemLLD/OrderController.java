package InventoryManagementSystemLLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderController {
    public List<Order> orderList;
    public Map<Integer,List<Order>> userIDvsOrders;

    public OrderController() {
        orderList=new ArrayList<>();
        userIDvsOrders=new HashMap<>();
    }

    public Order createOrder(User user,Warehouse warehouse) {
        Order order=new Order(user,warehouse);
        orderList.add(order);

        if (userIDvsOrders.containsKey(user.userId)) {
            List<Order> userOrders=userIDvsOrders.get(user.userId);
            userOrders.add(order);
            userIDvsOrders.put(user.userId,userOrders);
        } else {
            List<Order> userOrders=new ArrayList<>();
            userOrders.add(order);
            userIDvsOrders.put(user.userId,userOrders);
        }

        return order;
    }

    public void removeOrder(Order order) {

    }

    public List<Order> getOrderByCustomerId(int userId) {
        return userIDvsOrders.getOrDefault(userId,new ArrayList<>());
    }

    public Order getOrderByOrderId(int orderId) {
        return null;
    }

}
