package VendingMachine;

public enum Coin {
    One(1),
    Five(5),
    Ten(10),
    Twenty(20);

    public int value;

    Coin(int value) {
        this.value=value;
    }
}
