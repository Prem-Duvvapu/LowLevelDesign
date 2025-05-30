package SplitwiseLLD.Expense;

import SplitwiseLLD.*;
import SplitwiseLLD.Expense.Split.ExpenseSplit;
import SplitwiseLLD.Expense.Split.Split;
import SplitwiseLLD.User.User;

import java.util.List;

public class ExpenseController {
    BalanceSheetController balanceSheetController;

    public ExpenseController() {
        balanceSheetController=new BalanceSheetController();
    }

    public Expense createExpense(String expenseId,String description,double expenseAmount,
                                    User paidByUser,ExpenseSplitType splitType,List<Split> splitList) {
        ExpenseSplit expenseSplit=SplitFactory.getSplitObject(splitType);
        expenseSplit.validateSplitRequest(splitList, expenseAmount);
    
        Expense expense=new Expense(expenseId, description, expenseAmount, paidByUser, splitType, splitList);
        balanceSheetController.updateUserExpenseBalanceSheet(paidByUser,splitList,expenseAmount);

        return expense;
    }
}
