package ATMLLD;

public class User {
    BankAccount account;
    Card card;

    BankAccount getBankAccount() {
        return account;
    }

    void setBankAccount(BankAccount account) {
        this.account=account;
    }

    Card getCard() {
        return card;
    }

    void setCard(Card card) {
        this.card=card;
    }
}
