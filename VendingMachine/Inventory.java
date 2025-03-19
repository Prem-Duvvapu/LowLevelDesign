package VendingMachine;

public class Inventory {
    ItemShelf[] inventory=null;

    Inventory(int itemCount) {
        inventory=new ItemShelf[itemCount];
        initializeEmptyInventory();
    }

    void initializeEmptyInventory() {
        int startCode=101;

        for (int i=0;i<inventory.length;i++) {
            ItemShelf itemShelf=new ItemShelf();

            itemShelf.setCode(startCode);
            itemShelf.setIsSoldOut(true);

            inventory[i]=itemShelf;
        }
    }

    void addItem(Item item,int code) throws Exception {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode()==code) {
                if (itemShelf.getIsSoldOut()) {
                    itemShelf.setItem(item);
                    itemShelf.setIsSoldOut(true);
                } else {
                    throw new Exception("Item already exists...");
                }
            }
        }
    }

    Item getItem(int code) throws Exception {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode()==code) {
                if (!itemShelf.getIsSoldOut()) {
                    return itemShelf.getItem();
                } else {
                    throw new Exception("Item already soldout...");
                }
            }
        }

        throw new Exception("Invalid code...");
    }

    void updateSoldOutItem(int code) {
        for (ItemShelf itemShelf: inventory) {
            if (itemShelf.getCode()==code) {
                itemShelf.setIsSoldOut(true);
            }
        }
    }
}
