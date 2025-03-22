package SplitwiseLLD;
import java.util.*;

public class UserExpenseBalanceSheet {
    public Map<String,Balance> userVsBalance;
    public double totalYourExpense;
    public double totalPayment;
    public double totalYouOwe;
    public double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        userVsBalance=new HashMap<>();
        totalYourExpense=0;
        totalPayment=0;
        totalYouOwe=0;
        totalYouGetBack=0;
    }
}
