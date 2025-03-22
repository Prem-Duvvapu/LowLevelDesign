package WeightMachineLLD.Client;

import WeightMachineLLD.Adaptee.WeightMachineForBabies;
import WeightMachineLLD.Adapter.WeightMachineAdapter;
import WeightMachineLLD.Adapter.WeightMachineAdapterImp;
import java.lang.reflect.AnnotatedParameterizedType;

public class Main {
    WeightMachine adaptee=new WeightMachineForBabies();
    WeightMachineAdapter adapter=new WeightMachineAdapterImp(adaptee);

    System.out.println(adaptee.getWeightInPounds()+"pounds equals to "+adapter.getWeightInKgs()+"kgs");
}
