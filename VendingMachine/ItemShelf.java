package VendingMachine;

public class ItemShelf {
    Item item;
    int code;
    boolean isSoldOut;

    Item getItem() {
        return item;
    }

    void setItem(Item item) {
        this.item=item;
    }

    int getCode() {
        return code;
    }

    void setCode(int code) {
        this.code=code;
    }

    boolean getIsSoldOut() {
        return isSoldOut;
    }

    void setIsSoldOut(boolean isSoldOut) {
        this.isSoldOut=isSoldOut;
    }
}
