package VendingMachine;

import java.util.List;

public class SelectionState implements VendingMachineState {
    SelectionState() {
        System.out.println("The Vending Machine is in selected state...");
    }

    @Override
    public void clickOnInsertCoinsButton(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't click on insert coins button in selection state...");
    }

    @Override
    public void insertCoin(VendingMachineImp machine,Coin coin) throws Exception {
        throw new Exception("Can't insert coins in selection state...");
    }

    @Override
    public void clickOnToStartProductCodeButton(VendingMachineImp machine) throws Exception {
        return;
    }

    @Override
    public void enterProductCode(VendingMachineImp machine, int productCode) throws Exception {
        Item item=machine.getInventory().getItem(productCode);
        int amountPaidByUser=0;

        for (Coin coin: machine.getCoinsList())
            amountPaidByUser+=coin.value;

        if (amountPaidByUser < item.getPrice()) {
            System.out.println("Insufficent Amount...");
            getFullRefund(machine);
            throw new Exception("Insufficient Amount...");
        } else {
            int remainingAmount=item.getPrice()-amountPaidByUser;
            if (remainingAmount>0)
                getChange(remainingAmount);
            machine.setVendingMachineState(new DispenseState(machine,productCode));
        }
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        //Generally this should be sent to tray
        System.out.println("The change is returned...");
        return extraMoney;
    }

    @Override
    public Item dispenseProduct(VendingMachineImp machine,int productCode) throws Exception {
        throw new Exception("Can't dispense product in selection state...");
    }

    @Override
    public List<Coin> getFullRefund(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't get full refund in selection state...");
    }

    @Override
    public void updateInventory(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't update inventory in selection state...");
    }
}
