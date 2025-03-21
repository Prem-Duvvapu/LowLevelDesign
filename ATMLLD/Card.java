package ATMLLD;

public class Card {
    private String cardNumber;
    private int cvv;
    private String expirtyDate;
    private String pin="1234";
    private BankAccount account;

    String getCardNumber() {
        return cardNumber;
    }

    void setCardNumber(String cardNumber) {
        this.cardNumber=cardNumber;
    }

    int getCvv() {
        return cvv;
    }

    void setCvv(int cvv) {
        this.cvv=cvv;
    }

    String getExpiryDate() {
        return expirtyDate;
    }

    void setExpiryDate(String expiryDate) {
        this.expirtyDate=expiryDate;
    }

    String getPin() {
        return pin;
    }

    void setPin(String pin) {
        this.pin=pin;
    }

    boolean isCorrectPinEntered(String pin) {
        return this.pin.equals(pin);
    }

    BankAccount getBankAccount() {
        return account;
    }
    
    void setBankAccount(BankAccount account) {
        this.account=account;
    }
}
