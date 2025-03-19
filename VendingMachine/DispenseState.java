package VendingMachine;

import java.util.List;

public class DispenseState implements VendingMachineState {
    DispenseState(VendingMachineImp machine, int productCode) throws Exception{
        System.out.println("The product is in dispense state...");
        dispenseProduct(machine, productCode);
    }
    
    @Override
    public void clickOnInsertCoinsButton(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't click on insert coins button in dispense state...");
    }

    @Override
    public void insertCoin(VendingMachineImp machine,Coin coin) throws Exception {
        throw new Exception("Can't insert coins in dispense state...");
    }

    @Override
    public void clickOnToStartProductCodeButton(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't click on start taking product code button in dispense state...");
    }

    @Override
    public void enterProductCode(VendingMachineImp machine, int productCode) throws Exception {
        throw new Exception("Can't enter product code in dispense state...");
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        throw new Exception("Can't get change in dispense state...");
    }

    @Override
    public Item dispenseProduct(VendingMachineImp machine,int productCode) throws Exception {
        System.out.println("The product has been dispensed...");
        Item item=machine.getInventory().getItem(productCode);
        machine.getInventory().updateSoldOutItem(productCode);
        machine.setVendingMachineState(new IdleState(machine));
        return item;
    }

    @Override
    public List<Coin> getFullRefund(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't get full refund in dispense state...");
    }

    @Override
    public void updateInventory(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't update inventory in dispense state...");
    }
}
