package SplitwiseLLD.Expense.Split;
import java.util.*;

public interface ExpenseSplit {
    public void validateSplitRequest(List<Split> splitList,double totalAmount);
}
