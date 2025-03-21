package ATMLLD;

public class BankAccount {
    int balance;

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance=balance;
    }

    public void withDrawBalance(int amount) {
        balance=balance-amount;
    }
}
