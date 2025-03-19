package VendingMachine;

public class Main {
    public static void main(String[] args) {
        VendingMachineImp machineImp=new VendingMachineImp();

        try {
            System.out.println("|\nFilling Up Inventory\n|");

            fillUpInventory(machineImp);
            displayInventory(machineImp);

            VendingMachineState state=machineImp.getVendingMachineState();
            System.out.println("|\nClicked on Insert Coins Button\n|");
            state.clickOnInsertCoinsButton(machineImp);

            state=machineImp.getVendingMachineState();
            state.insertCoin(machineImp, Coin.Five);
            state.insertCoin(machineImp, Coin.Ten);

            state=machineImp.getVendingMachineState();
            System.out.println("|\nClicked on start entering product code button\n|");
            state.clickOnToStartProductCodeButton(machineImp);

            state=machineImp.getVendingMachineState();
            state.enterProductCode(machineImp,103);

            displayInventory(machineImp);
        } catch(Exception e) {
            displayInventory(machineImp);
        }
    }

    public static void fillUpInventory(VendingMachineImp machineImp) {
        ItemShelf[] slots=machineImp.getInventory().getInventory();
        Item newItem=new Item();

        for (int i=0;i<slots.length;i++) {
            if (i>=0 && i<3) {
                newItem.setItemType(ItemType.Coke);
                newItem.setPrice(25);
            } else if (i>=3 && i<5) {
                newItem.setItemType(ItemType.Pepsi);
                newItem.setPrice(15);
            } else if (i>=5 && i<7) {
                newItem.setItemType(ItemType.Soda);
                newItem.setPrice(20);
            } else {
                newItem.setItemType(ItemType.Water);
                newItem.setPrice(10);
            }

            slots[i].setItem(newItem);
            slots[i].setIsSoldOut(false);
        }
    }

    public static void displayInventory(VendingMachineImp machineImp) {
        ItemShelf[] slots=machineImp.getInventory().getInventory();

        for (ItemShelf slot : slots) {
            System.out.println("Item Type: " + slot.getItem().getItemType() + " Code: " + slot.getCode() + " Price: " + slot.getItem().getPrice() + " Is Avaiable: " + !slot.getIsSoldOut());
        }
    }
}
