package SplitwiseLLD;
import java.util.*;

public class UserExpenseBalanceSheet {
    Map<String,Balance> userVsBalance;
    double totalYourExpense;
    double totalPayment;
    double totalYouOwe;
    double totalYouGetBack;

    public UserExpenseBalanceSheet() {
        userVsBalance=new HashMap<>();
        totalYourExpense=0;
        totalPayment=0;
        totalYouOwe=0;
        totalYouGetBack=0;
    }
}
