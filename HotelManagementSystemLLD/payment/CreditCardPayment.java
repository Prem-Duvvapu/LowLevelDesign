package HotelManagementSystemLLD.payment;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
