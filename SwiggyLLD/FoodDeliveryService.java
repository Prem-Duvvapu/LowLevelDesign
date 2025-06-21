package SwiggyLLD;

import SwiggyLLD.order.*;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class FoodDeliveryService {
    private static FoodDeliveryService instance;
    private final Map<String, Customer> customers;
    private final Map<String, Restaurant> restaurants;
    private final Map<String, Order> orders;
    private final Map<String, DeliveryAgent> deliveryAgents;

    private FoodDeliveryService() {
        customers=new ConcurrentHashMap<>();
        restaurants=new ConcurrentHashMap<>();
        orders=new ConcurrentHashMap<>();
        deliveryAgents=new ConcurrentHashMap<>();
    }

    public static synchronized FoodDeliveryService getInstance() {
        if (instance==null)
            instance=new FoodDeliveryService();

        return instance;
    }

    public Customer registerCustomer(String name, String email, String phone) {
        Customer customer=new Customer(name, email, phone);
        customers.put(customer.getId(),customer);
        return customer;
    }

    public Restaurant registerRestaurant(String name,String address) {
        Restaurant restaurant=new Restaurant(name, address);
        restaurants.put(restaurant.getId(),restaurant);
        return restaurant;
    }

    public DeliveryAgent registerDeliveryAgent(String name, String phoneNum) {
        DeliveryAgent deliveryAgent=new DeliveryAgent(name, phoneNum);
        deliveryAgents.put(deliveryAgent.getId(),deliveryAgent);
        return deliveryAgent;
    }

    public List<String> getAvailableRestaurantNames() {
        List<String> restaurantNames=new ArrayList<>();
        for (Restaurant restaurant: restaurants.values())
            restaurantNames.add(restaurant.getName());

        return restaurantNames;
    }

    public List<String> getRestaurantMenu(String restaurantId) {
        List<String> menuItemsDetails=new ArrayList<>();
        Restaurant restaurant=restaurants.get(restaurantId);

        if (restaurant!=null) {
            for (MenuItem menuItem: restaurant.getMenu())
                menuItemsDetails.add(menuItem.getMenuItem());
        }

        return menuItemsDetails;
    }

    public void addMenuItem(String restaurantId, String name, String description, double price) {
        Restaurant restaurant=restaurants.get(restaurantId);
        if (restaurant==null)
            throw new IllegalArgumentException("Invalid restaurant");
        
        restaurant.addMenuItem(new MenuItem(name, description, price));
    }

    public Order placeOrder(String customerId, String restaurantId, List<String> itemNames) {
        Customer customer=customers.get(customerId);
        Restaurant restaurant=restaurants.get(restaurantId);

        if (customer!=null && restaurant!=null) {
            List<MenuItem> items=restaurant.getMenu().stream()
                                    .filter(m -> itemNames.contains(m.getName()))
                                    .toList();
            
            Order order=new Order(customer, restaurant, items);
            notifyRestaurant(order);
            System.out.println("Order placed: "+order.getId());

            return order;
        }

        return null;
    }

    public void cancelOrder(String orderId) {
        Order order=orders.get(orderId);

        if (order!=null && order.getStatus()==OrderStatus.PENDING) {
            order.updateStatus(OrderStatus.CANCELLED);
            notifyCustomer(order);
            notifyRestaurant(order);
            System.out.println("Order cancelled: "+order.getId());
        }
    }

    public void updateOrderStatus(String orderId, OrderStatus status) {
        Order order=orders.get(orderId);

        if (order!=null) {
            order.updateStatus(status);
            System.out.println("Order "+orderId+" udpated to "+status);

            notifyCustomer(order);

            if (order.getStatus()==OrderStatus.DELIVERED && order.getDeliveryAgent()!=null) {
                order.getDeliveryAgent().release();
            }
        }
    }

    public synchronized void assignDeliveryAgent(String orderId) {
        Order order=orders.get(orderId);

        if (order==null)
            throw new IllegalArgumentException("Order not found");

        for (DeliveryAgent agent: deliveryAgents.values()) {
            if (agent.isAvailable()) {
                agent.assign();
                order.assignDeliveryAgent(agent);
                notifyDeliveryAgent(order);
                System.out.println("Agent "+agent.getName()+" assigned to order "+orderId);
                return;
            }
        }

        throw  new IllegalStateException("No delivery agent is available");
    }

    private void notifyRestaurant(Order order) {
        System.out.println("Notified the restaurant...");
    }

    private void notifyCustomer(Order order) {
        System.out.println("Notified the customer...");
    }

    private void notifyDeliveryAgent(Order order) {
        System.out.println("Notified the delivery agent...");
    }
}
