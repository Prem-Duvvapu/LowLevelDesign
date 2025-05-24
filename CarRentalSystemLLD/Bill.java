package CarRentalSystemLLD;

public class Bill {
    public Reservation reservation;
    public double totalBillAmount;
    public boolean isBillPaid;

    public Bill(Reservation reservation) {
        this.reservation=reservation;
        this.totalBillAmount=computeBillAmount();
        isBillPaid=false;
    }

    private double computeBillAmount() {
        return 100.0;
    }

}
