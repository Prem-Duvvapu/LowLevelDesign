package VendingMachine;

import java.util.List;

public class HasMoneyState implements VendingMachineState {
    HasMoneyState() {
        System.out.println("The Vending Machine is in has money state...");
    }

    @Override
    public void clickOnInsertCoinsButton(VendingMachineImp machine) throws Exception {
        return;
    }

    @Override
    public void insertCoin(VendingMachineImp machine,Coin coin) throws Exception {
        System.out.println("Accepted the coin...");
        machine.getCoinsList().add(coin);
    }

    @Override
    public void clickOnToStartProductCodeButton(VendingMachineImp machine) throws Exception {
        machine.setVendingMachineState(new SelectionState());
    }

    @Override
    public void enterProductCode(VendingMachineImp machine, int productCode) throws Exception {
        throw new Exception("Can't enter product code in has money state...");
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        throw new Exception("Can't get change in has money state...");
    }

    @Override
    public Item dispenseProduct(VendingMachineImp machine,int productCode) throws Exception {
        throw new Exception("Can't dispense product in has money state...");
    }

    @Override
    public List<Coin> getFullRefund(VendingMachineImp machine) throws Exception {
        System.out.println("Sending the full refund...");
        List<Coin> refundCoinsList=machine.getCoinsList();
        machine.setVendingMachineState(new IdleState(machine));
        return refundCoinsList;
    }

    @Override
    public void updateInventory(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't update inventory in has money state...");
    }
}
