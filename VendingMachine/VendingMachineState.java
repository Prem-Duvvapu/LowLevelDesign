package VendingMachine;

import java.util.List;

public interface VendingMachineState {
    public void clickOnInsertCoinsButton(VendingMachineImp machine) throws Exception;

    public void insertCoin(VendingMachineImp machine,Coin coin) throws Exception;

    public void clickOnToStartProductCodeButton(VendingMachineImp machine) throws Exception;

    public void enterProductCode(VendingMachineImp machine, int productCode) throws Exception;

    public int getChange(int extraMoney) throws Exception;

    public Item dispenseProduct(VendingMachineImp machine,int productCode) throws Exception;

    public List<Coin> getFullRefund(VendingMachineImp machine) throws Exception;

    public void updateInventory(VendingMachineImp machine) throws Exception;
}
