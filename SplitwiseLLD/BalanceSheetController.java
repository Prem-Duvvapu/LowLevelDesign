package SplitwiseLLD;
import java.util.*;

public class BalanceSheetController {
    public void updateUserExpenseBalanceSheet(User expensePaidBy, List<Split> splist,double totalExpenseAmount) {
        UserExpenseBalanceSheet paidByUserExpenseSheet=expensePaidBy.userExpenseBalanceSheet;
        paidByUserExpenseSheet.totalPayment=paidByUserExpenseSheet.totalPayment+totalExpenseAmount;

        for (Split split: splits) {
            User userOwe=split.getUser();
            UserExpenseBalanceSheet oweUserExpenseSheet=userOwe.userExpenseBalanceSheet;
            double oweAmount=split.amountOwe;

            if (expensePaidBy.userId.equals(userOwe.userId)) {
                paidByUserExpenseSheet.totalYourExpense=paidByUserExpenseSheet.totalYourExpense+oweAmount;
            } else {
                paidByUserExpenseSheet.totalYouGetBack=paidByUserExpenseSheet.totalYouGetBack+oweAmount;

                Balance userOweBalance;
                if (paidByUserExpenseSheet.userVsBalance.containsKey(userOwe.userId)) {
                    userOweBalance=paidByUserExpenseSheet.userVsBalance.get(userOwe.userId);
                } else {
                    userOweBalance=new Balance();
                    paidByUserExpenseSheet.userVsBalance.put(userOwe.userId,userOweBalance);
                }

                userOweBalance.amountGetBack=userOweBalance.amountGetBack+oweAmount;

                //update the balance of owe user
                oweUserExpenseSheet.totalYouOwe=oweUserExpenseSheet.totalYouOwe+oweAmount;
                oweUserExpenseSheet.totalYourExpense=oweUserExpenseSheet.totalYourExpense+oweAmount;

                Balance userPaidBalance;
                if (oweUserExpenseSheet.userVsBalance.containsKey(expensePaidBy.userId)) {
                    userPaidBalance=oweUserExpenseSheet.userVsBalance.get(expensePaidBy.userId);
                } else {
                    userPaidBalance=new Balance();
                    oweUserExpenseSheet.userVsBalance.put(expensePaidBy.userId,userPaidBalance);
                }
                userPaidBalance.amountOwe=userPaidBalance.amountOwe+oweAmount;
            }
        }
    }

    public void showBalanceSheetOfUser(User user) {
        System.out.println("--------------------------------------------");
        
        System.out.println("Balance sheet of user: "+user.userId);

        UserExpenseBalanceSheet userExpenseBalanceSheet=user.userExpenseBalanceSheet;

        System.out.println("TotalYourExpense: "+userExpenseBalanceSheet.totalYourExpense);
        System.out.println("TotalPaymentMade: "+userExpenseBalanceSheet.totalPayment);
        System.out.println("TotalGetBack: "+userExpenseBalanceSheet.totalYouGetBack);
        System.out.println("TotalYouOwe: "+userExpenseBalanceSheet.totalYouOwe);

        for (Map.Entry<String,Balance> entry: userExpenseBalanceSheet.userVsBalance.entrySet()) {
            String userId=entry.getKey();
            Balance balance=entry.getValue();

            System.out.println("User ID: "+userId+" You Get Back: "+balance.amountOwe+" You Owe: "+balance.amountGetBack);
        }

        System.out.println("--------------------------------------------");
    }
}
