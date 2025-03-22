package SplitwiseLLD.Expense;

import SplitwiseLLD.Expense.Split.EqualExpenseSplit;
import SplitwiseLLD.Expense.Split.UnequalExpenseSplit;

public class SplitFactory {
    public stattic ExpenseSplit getSplitObject(ExpenseSplitType splitType) {
        switch (splitType) {
            case EQUAL:
                return new EqualExpenseSplit();
            case UNEQUAL:
                return new UnequalExpenseSplit();
            case PERCENTAGE:
                return new Percentage();
            default:
                return NULL;
        }
    }
}
