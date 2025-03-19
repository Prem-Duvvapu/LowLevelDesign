package VendingMachine;

import java.util.ArrayList;
import java.util.List;

public class IdleState implements VendingMachineState {
    IdleState() {
        System.out.println("The Vending Machine is in idle state...");
    }

    IdleState(VendingMachineImp machine) {
        System.out.println("The Vending Machine is in idle state...");
        machine.setCoinsList(new ArrayList<>());
    }


    @Override
    public void clickOnInsertCoinsButton(VendingMachineImp machine) throws Exception {
        machine.setVendingMachineState(new HasMoneyState());
    }

    @Override
    public void insertCoin(VendingMachineImp machine,Coin coin) throws Exception {
        throw new Exception("Can't insert coins in idle state...");
    }

    @Override
    public void clickOnToStartProductCodeButton(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't click on start taking product code button in idle state...");
    }

    @Override
    public void enterProductCode(VendingMachineImp machine, int productCode) throws Exception {
        throw new Exception("Can't enter product code in idle state...");
    }

    @Override
    public int getChange(int extraMoney) throws Exception {
        throw new Exception("Can't get change in idle state...");
    }

    @Override
    public Item dispenseProduct(VendingMachineImp machine,int productCode) throws Exception {
        throw new Exception("Can't dispense product in idle state...");
    }

    @Override
    public List<Coin> getFullRefund(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't get full refund in idle state...");
    }

    @Override
    public void updateInventory(VendingMachineImp machine) throws Exception {
        throw new Exception("Can't update inventory in idle state...");
    }
}
