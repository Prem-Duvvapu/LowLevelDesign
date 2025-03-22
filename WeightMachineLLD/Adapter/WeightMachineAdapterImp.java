package WeightMachineLLD.Adapter;

import WeightMachineLLD.Adaptee.WeightMachine;


public class WeightMachineAdapterImp implements WeightMachineAdapter {
    WeightMachine machine;

    public WeightMachineAdapterImp(WeightMachine machine) {
        this.machine=machine;
    }

    @Override
    public double getWeightInKgs() {
        double weightInPounds=machine.getWeightInPounds();
        double weightInKgs=weightInPounds*0.45;

        return weightInKgs;
    }
}
