package SwiggyLLD.order;

import SwiggyLLD.*;
import java.util.*;


public class Order {
    private final String id;
    private final Customer customer;
    private final Restaurant restaurant;
    private final List<MenuItem> orderItems;
    private OrderStatus status;
    private DeliveryAgent deliveryAgent;

    public Order(Customer customer, Restaurant restaurant, List<MenuItem> items) {
        this.id="ORD"+UUID.randomUUID().toString();
        this.customer=customer;
        this.restaurant=restaurant;
        this.orderItems=items;
        this.status=OrderStatus.PENDING;
    }

    public void addItem(MenuItem item) {
        orderItems.add(item);
    }
    
    public void removeItem(MenuItem item) {
        orderItems.remove(item);
    }

    public void updateStatus(OrderStatus status) {
        this.status=status;
    }

    public void assignDeliveryAgent(DeliveryAgent agent) {
        this.deliveryAgent=agent;
    }

    public String getId() {
        return id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public List<MenuItem> getOrderItems() {
        return orderItems;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public DeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }


}
