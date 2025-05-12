package InventoryManagementSystemLLD;

public class Invoice {
    public int totalItemPrice;
    public int totalTax;
    public int totalFinalPrice;

    public void generateInvoice(Order order) {
        totalItemPrice=200;
        totalTax=20;
        totalFinalPrice=totalItemPrice+totalFinalPrice;
    }
}
