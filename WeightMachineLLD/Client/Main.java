package WeightMachineLLD.Client;

import WeightMachineLLD.Adaptee.WeightMachineForBabies;
import WeightMachineLLD.Adapter.WeightMachineAdapter;
import WeightMachineLLD.Adapter.WeightMachineAdapterImp;
import WeightMachineLLD.Adaptee.WeightMachine;

public class Main {
    public static void main(String[] args) {
        WeightMachine adaptee=new WeightMachineForBabies();
        WeightMachineAdapter adapter=new WeightMachineAdapterImp(adaptee);

        System.out.println(adaptee.getWeightInPounds()+" pounds equals to "+adapter.getWeightInKgs()+" kgs");
    }
}
