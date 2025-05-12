package InventoryManagementSystemLLD;

import java.util.Map;

public class Order {
    public User user;
    public Address deliveryAddress;
    public Map<Integer,Integer> productCategoryAndCountMap;
    public Warehouse warehouse;
    public Invoice invoice;
    public Payment payment;
    public OrderStatus orderStatus;

    public Order(User user,Warehouse warehouse) {
        this.user=user;
        this.deliveryAddress=user.address;
        this.productCategoryAndCountMap=user.userCartDetails.getCartItems();
        this.warehouse=warehouse;
        this.invoice=new Invoice();
        invoice.generateInvoice(this);
    }

    public void checkout() {
        //1. update inventory
        warehouse.removeFromInventory(productCategoryAndCountMap);

        //2. make payment
        boolean isPaymentSuccess=makePayment(new UPIPaymentMode());

        //3 .make cart empty
        if (isPaymentSuccess)
            user.userCartDetails.emptyCart();
        else
            warehouse.addItemToInventory(productCategoryAndCountMap);
    }

    public boolean makePayment(PaymentMode paymentMode) {
        payment=new Payment(paymentMode);
        return payment.makePayment();
    }

    public void generateOrderInvoice() {
        invoice.generateInvoice(this);
    }
}
