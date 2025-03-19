package VendingMachine;

public class Item {
    ItemType itemType;
    int price;

    ItemType getItemType() {
        return itemType;
    }

    void setItemType(ItemType itemType) {
        this.itemType=itemType;
    }

    int getPrice() {
        return price;
    }

    void setPrice(int price) {
        this.price=price;
    }
}
